package br.com.odin.sample.todolist.infrastructure.adapters.repositories;

import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import br.com.odin.sample.todolist.infrastructure.adapters.entities.ToDoEntity;
import org.springframework.stereotype.Component;

@Component
public class ToDoRepository implements ToDoRepositoryPort {

    private final SpringToDoRepository springToDoRepository;

    public ToDoRepository(SpringToDoRepository springToDoRepository) {
        this.springToDoRepository = springToDoRepository;
    }

    @Override
    public void add(ToDo toDo) {
        ToDoEntity toDoEntity = new ToDoEntity(toDo.getName());
        toDoEntity.setToDoItemEntity(toDo.getToDoItem());

        this.springToDoRepository.save(toDoEntity);
    }

    @Override
    public ToDo getById(ToDo toDo) {
        ToDoEntity toDoEntity = this.springToDoRepository.getById(toDo.getId());

        return new ToDo(toDoEntity.getName(),toDoEntity.getToDoItem());
    }
}
