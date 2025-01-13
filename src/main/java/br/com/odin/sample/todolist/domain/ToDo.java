package br.com.odin.sample.todolist.domain;

import java.util.Date;
import java.util.List;

public class ToDo {

    private Long id;
    private String name;
    private List<ToDoItem> toDoItem;
    private Date createdDate;

    public ToDo(String name, List<ToDoItem> toDoItem, Date createdDate) {
        this.name = name;
        this.toDoItem = toDoItem;
        this.createdDate = createdDate;
    }

    public ToDo(Long id) {
        this.id = id;
    }

    public ToDo(String name, Long id, List<ToDoItem> toDoItem, Date createdDate) {
        this.id = id;
        this.name = name;
        this.toDoItem = toDoItem;
        this.createdDate = createdDate;
    }

    public ToDo(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Date getCreatedDate() {
        return createdDate;
    }
}
