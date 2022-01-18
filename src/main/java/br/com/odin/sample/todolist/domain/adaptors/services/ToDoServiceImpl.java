package br.com.odin.sample.todolist.domain.adaptors.services;

import br.com.odin.sample.todolist.application.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.application.dtos.ToDoResponseDTO;
import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ToDoItem;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class ToDoServiceImpl implements ToDoServicePort {

    private final ToDoRepositoryPort toDoRepositoryPort;

    public ToDoServiceImpl(ToDoRepositoryPort toDoRepositoryPort ) {
        this.toDoRepositoryPort = toDoRepositoryPort;
    }

    @Override
    public void add(ToDoRequestDTO toDoDTO) {
        // avaliar um mapper

        ToDoItem toDoItem = new ToDoItem(toDoDTO.getItems());

        ToDo toDo = new ToDo(toDoDTO.getName(), toDoItem.toObject());

        this.toDoRepositoryPort.add(toDo);
    }

    @Override
    public void remove(ToDoRequestDTO toDoDTO) {

    }

    @Override
    public void update(ToDoRequestDTO toDoDTO) {

    }

    @Override
    public ToDoResponseDTO get(Long id) {

        ToDo toDo = new ToDo(id);
        toDo = this.toDoRepositoryPort.getById(toDo);

        return new ToDoResponseDTO(toDo.getName(), new ToDoItem().toDTO(toDo.getToDoItem()));
    }

    @Override
    public List<ToDoResponseDTO> get() {

       List<ToDo> toDoList =  this.toDoRepositoryPort.get();

       List<ToDoResponseDTO> toDoResponseDTOList = new ArrayList<>();

        for (ToDo toDo:toDoList ) {
            toDoResponseDTOList.add(new ToDoResponseDTO(toDo.getName(), new ToDoItem().toDTO(toDo.getToDoItem())));
        }

        return toDoResponseDTOList;
    }


}
