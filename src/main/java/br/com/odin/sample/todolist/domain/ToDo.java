package br.com.odin.sample.todolist.domain;

import java.util.List;

public class ToDo {

    private Long id;
    private String name;
    private List<ToDoItem> toDoItem;

    public ToDo(String name, List<ToDoItem> toDoItem) {
        this.name = name;
        this.toDoItem = toDoItem;
    }

    public ToDo(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public List<ToDoItem> getToDoItem() {
        return toDoItem;
    }

    public Long getId() {
        return id;
    }
}
