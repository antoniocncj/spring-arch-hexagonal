package br.com.odin.sample.todolist.infrastructure.configs;

import br.com.odin.sample.todolist.domain.adaptors.services.ToDoServiceImpl;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import br.com.odin.sample.todolist.shared.avro.TodoListAvro;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ToDoServicePort toDoService(ToDoRepositoryPort toDoRepositoryPort , Producer<String, TodoListAvro> producer) {
        return new ToDoServiceImpl(toDoRepositoryPort, producer);
    }
}
