package br.com.odin.sample.todolist.domain.ports.interfaces;

import br.com.odin.sample.todolist.domain.dtos.ToDoDTO;

import java.util.List;

public interface ToDoServicePort {

    void add(ToDoDTO toDoDTO);

    void remove(ToDoDTO toDoDTO);

    void update(ToDoDTO toDoDTO);

    ToDoDTO get(Long idToDoList);

}
