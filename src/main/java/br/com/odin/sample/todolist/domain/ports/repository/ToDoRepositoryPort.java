package br.com.odin.sample.todolist.domain.ports.repository;

import br.com.odin.sample.todolist.domain.ToDo;

import java.util.List;

public interface ToDoRepositoryPort {

    void add(ToDo toDo);

    ToDo getById(ToDo toDo);
}
