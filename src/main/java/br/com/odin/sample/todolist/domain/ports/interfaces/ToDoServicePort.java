package br.com.odin.sample.todolist.domain.ports.interfaces;

import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoResponseDTO;


import java.util.List;

public interface ToDoServicePort {

    void add(ToDoRequestDTO toDoDTO);

    ToDoResponseDTO get(Long idToDoList);

    List<ToDoResponseDTO> get();
}
