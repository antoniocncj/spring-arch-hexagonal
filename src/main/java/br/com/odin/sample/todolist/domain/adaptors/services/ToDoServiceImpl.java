package br.com.odin.sample.todolist.domain.adaptors.services;

import br.com.odin.sample.todolist.shared.avro.TodoListAvro;
import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoResponseDTO;
import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ToDoItem;
import br.com.odin.sample.todolist.domain.ports.interfaces.MessagingPort;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.ArrayList;
import java.util.List;

public class ToDoServiceImpl implements ToDoServicePort , MessagingPort<TodoListAvro> {

    private final ToDoRepositoryPort toDoRepositoryPort;

    private final Producer<String, TodoListAvro> producer;


    public ToDoServiceImpl(ToDoRepositoryPort toDoRepositoryPort, @Qualifier("producerTodoList") Producer<String,TodoListAvro> producer) {
        this.toDoRepositoryPort = toDoRepositoryPort;
        this.producer = producer;
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
    public void send(TodoListAvro toDoRequestDTO) {

        producer.send(this.createProducerRecord(toDoRequestDTO), (rm, ex) -> {
            if (ex == null) {
               // System.out.println("TodoList enviada com sucesso!!!");
            } else {
               // System.out.println("Falha no envio da todolist", ex);
            }
        });
    }
}
