package br.com.odin.sample.todolist.domain.ports.repository;

import br.com.odin.sample.todolist.domain.ToDoItem;

public interface ToDoItemRepositoryPort {

    void add(ToDoItem toDoItem);

}
