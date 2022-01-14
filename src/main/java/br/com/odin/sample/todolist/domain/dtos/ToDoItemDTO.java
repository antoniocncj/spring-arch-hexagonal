package br.com.odin.sample.todolist.domain.dtos;

import br.com.odin.sample.todolist.domain.Status;

import java.util.Date;

public class ToDoItemDTO {

    private String name;
    private Date targetDate;
    private Status status;

    public ToDoItemDTO(String name, Date targetDate, Status status) {
        this.name = name;
        this.targetDate = targetDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public Status getStatus() {
        return status;
    }
}
