package br.com.odin.sample.todolist.domain.adaptors.services;

import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ToDoItem;
import br.com.odin.sample.todolist.domain.dtos.ToDoDTO;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;

import java.util.List;

public class ToDoServiceImpl implements ToDoServicePort {

    private final ToDoRepositoryPort toDoRepositoryPort;

    public ToDoServiceImpl(ToDoRepositoryPort toDoRepositoryPort) {
        this.toDoRepositoryPort = toDoRepositoryPort;
    }

    @Override
    public void add(ToDoDTO toDoDTO) {
        // avaliar um mapper

        ToDoItem toDoItem = new ToDoItem(toDoDTO.getItems());

        ToDo toDo = new ToDo(toDoDTO.getName(), toDoItem.toObject());

        this.toDoRepositoryPort.add(toDo);
    }

    @Override
    public void remove(ToDoDTO toDoDTO) {

    }

    @Override
    public void update(ToDoDTO toDoDTO) {

    }

    @Override
    public ToDoDTO get(Long id) {

        ToDo toDo = new ToDo(id);
        toDo = this.toDoRepositoryPort.getById(toDo);

        return new ToDoDTO(toDo.getName(), new ToDoItem().toDTO(toDo.getToDoItem()));
    }


}
