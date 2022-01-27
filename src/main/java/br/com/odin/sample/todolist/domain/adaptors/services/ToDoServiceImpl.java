package br.com.odin.sample.todolist.domain.adaptors.services;

import br.com.odin.sample.todolist.shared.avro.TodoListAvro;
import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoResponseDTO;
import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ToDoItem;
import br.com.odin.sample.todolist.domain.ports.interfaces.MessagingPort;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.*;


public class ToDoServiceImpl implements ToDoServicePort , MessagingPort<TodoListAvro> {

    private final ToDoRepositoryPort toDoRepositoryPort;

    private final Producer<String, TodoListAvro> producer;

    private final Consumer<String, TodoListAvro> consumer;

    private final Object lock = new Object();


    public ToDoServiceImpl(ToDoRepositoryPort toDoRepositoryPort,
                           @Qualifier("producerTodoList") Producer<String,TodoListAvro> producer,
                           @Qualifier("consumerTodoList") Consumer<String,TodoListAvro> consumer) {
        this.toDoRepositoryPort = toDoRepositoryPort;
        this.producer = producer;
        this.consumer = consumer;

        this.read();
    }

    @Override
    public void add(ToDoRequestDTO toDoDTO) {
        // avaliar um mapper
        ToDoItem toDoItem = new ToDoItem(toDoDTO.getItems());

        ToDo toDo = new ToDo(toDoDTO.getName(), toDoItem.toObject());

        toDo = this.toDoRepositoryPort.add(toDo);

        TodoListAvro todoListAvro = new TodoListAvro(toDo.getId(), toDo.getName());

        this.send(todoListAvro);
    }


    @Override
    public ToDoResponseDTO get(Long id) {

        ToDo toDo = new ToDo(id);
        toDo = this.toDoRepositoryPort.getById(toDo);

        return new ToDoResponseDTO(toDo.getName(),
                                   toDo.getId(),
                                   new ToDoItem().toDTO(toDo.getToDoItem()));
    }

    @Override
    public List<ToDoResponseDTO> get() {

       List<ToDo> toDoList =  this.toDoRepositoryPort.get();

       List<ToDoResponseDTO> toDoResponseDTOList = new ArrayList<>();

        for (ToDo toDo:toDoList ) {
            toDoResponseDTOList.add(new ToDoResponseDTO(toDo.getName(),
                                                        toDo.getId(),
                                                        new ToDoItem().toDTO(toDo.getToDoItem())));
        }

        return toDoResponseDTOList;
    }

    @Override
    public String topic() {
        return "topico-todolist-managed";
    }

    @Override
    public ProducerRecord<String, TodoListAvro> createProducerRecord(TodoListAvro payload) {
        return new ProducerRecord<>(this.topic(), payload);
    }

    @Override
    public void send(TodoListAvro todoListAvro) {

        producer.send(this.createProducerRecord(todoListAvro), (rm, ex) -> {
            if (ex == null) {
                System.out.print("TodoList enviada com sucesso!!!" + todoListAvro.toString());
            } else {
                System.out.println("Falha no envio da todolist: " + ex);
            }
        });

    }

    @Override
    public void read() {

        //  somente para mostrar um consumidor rodando, isso estaria em outro microservico
        // com suas carateristicas de escalonamento
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                synchronized (lock) {
                    consume();
                }
            }
        }, 0, 1000);
    }

    //  somente para mostrar um consumidor rodando, isso estaria em outro microservico
    // com suas carateristicas de escalonamento, configuirações e etc.
    private void consume(){

        int messagesNotFound = 0;

        this.consumer.subscribe(Collections.singletonList(this.topic()));

        while (true) {

            ConsumerRecords<String, TodoListAvro> consumerRecords = this.consumer.poll(1000);

            if (consumerRecords.count() == 0) {
                messagesNotFound++;
                if (messagesNotFound > 100) break;
                else continue;
            }

            consumerRecords.forEach(record -> {
                System.out.println("Record Key " + record.key());
                System.out.println("Record value " + record.value());
                System.out.println("Record partition " + record.partition());
                System.out.println("Record offset " + record.offset());
            });
        }

        consumer.commitAsync();

        this.consumer.close();

    }
}
