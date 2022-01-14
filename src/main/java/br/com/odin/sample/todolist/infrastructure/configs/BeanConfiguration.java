package br.com.odin.sample.todolist.infrastructure.configs;

import br.com.odin.sample.todolist.domain.adaptors.services.ToDoServiceImpl;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ToDoServicePort toDoService(ToDoRepositoryPort toDoRepositoryPort) {
        return new ToDoServiceImpl(toDoRepositoryPort);
    }
}
