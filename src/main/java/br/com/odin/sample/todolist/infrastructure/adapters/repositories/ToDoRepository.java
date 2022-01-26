package br.com.odin.sample.todolist.infrastructure.adapters.repositories;

import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import br.com.odin.sample.todolist.infrastructure.adapters.entities.ToDoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ToDoRepository implements ToDoRepositoryPort {

    private final SpringToDoRepository springToDoRepository;

    public ToDoRepository(SpringToDoRepository springToDoRepository) {
        this.springToDoRepository = springToDoRepository;
    }

    @Override
    public ToDo add(ToDo toDo) {
        ToDoEntity toDoEntity = new ToDoEntity(toDo.getName());
        toDoEntity.setToDoItemEntity(toDo.getToDoItem());

        toDoEntity = this.springToDoRepository.save(toDoEntity);

        return new ToDo(toDoEntity.getId(), toDoEntity.getName());
    }

    @Override
    public ToDo getById(ToDo toDo) {
        Optional<ToDoEntity> toDoEntity = this.springToDoRepository.findById(toDo.getId());

        return new ToDo(toDoEntity.get().getName(), toDoEntity.get().getId(),toDoEntity.get().getToDoItem());
    }

    @Override
    public List<ToDo> get() {
        
        List<ToDoEntity> toDoEntityList = this.springToDoRepository.findAll();

        List<ToDo> toDoList = new ArrayList<>();

        for (ToDoEntity toDoEntity: toDoEntityList ) {
            toDoList.add(new ToDo(toDoEntity.getName(),toDoEntity.getToDoItem()));
        }

        return toDoList;
    }
}
