package br.com.odin.sample.todolist.domain.ports.repository;

import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.infrastructure.adapters.entities.ToDoEntity;

import java.util.List;

public interface ToDoRepositoryPort {

    ToDo add(ToDo toDo);

    ToDo getById(ToDo toDo);

    List<ToDo> get();
}
