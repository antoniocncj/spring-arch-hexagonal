package br.com.odin.sample.todolist.domain.ports.interfaces;

import br.com.odin.sample.todolist.domain.ToDoItem;

public interface ToDoItemServicePort {

    void add(ToDoItem toDoDTO);

    void remove(ToDoItem toDoDTO);

    void update(ToDoItem toDoDTO);
}
