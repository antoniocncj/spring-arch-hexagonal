package br.com.odin.sample.todolist.domain.dtos;

import java.util.List;

public class ToDoDTO {

    private String name;
    private List<ToDoItemDTO> items;

    public ToDoDTO(String name, List<ToDoItemDTO> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public List<ToDoItemDTO> getItems() {
        return items;
    }
}
