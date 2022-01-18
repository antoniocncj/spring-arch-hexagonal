package br.com.odin.sample.todolist.domain.ports.interfaces;

import br.com.odin.sample.todolist.application.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.application.dtos.ToDoResponseDTO;

import java.util.List;

public interface ToDoServicePort {

    void add(ToDoRequestDTO toDoDTO);

    void remove(ToDoRequestDTO toDoDTO);

    void update(ToDoRequestDTO toDoDTO);

    ToDoResponseDTO get(Long idToDoList);

    List<ToDoResponseDTO> get();
}
