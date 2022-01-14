package br.com.odin.sample.todolist.domain;

import br.com.odin.sample.todolist.domain.dtos.ToDoItemDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoItem {

    private String name;
    private Date targetDate;
    private Status status;
    private List<ToDoItemDTO> toDoItemDTOList;

    public ToDoItem() {

    }

    public ToDoItem(List<ToDoItemDTO> toDoItemDTOList) {
        this.toDoItemDTOList = toDoItemDTOList;
    }

    public ToDoItem(String name, Date targetDate, Status status) {
        this.name = name;
        this.targetDate = targetDate;
        this.status = status;
    }

    public List<ToDoItem> toObject() {

        List<ToDoItem> toDoItems = new ArrayList<>();
        for (ToDoItemDTO toDoItemDTO : this.toDoItemDTOList) {

            ToDoItem toDoItem = new ToDoItem(toDoItemDTO.getName(),
                    toDoItemDTO.getTargetDate(),
                    Status.Backlog);

            toDoItems.add(toDoItem);
        }

        return toDoItems;
    }

    public List<ToDoItemDTO> toDTO(List<ToDoItem> toDoItemList) {

        List<ToDoItemDTO> toDoItemDTOList = new ArrayList<>();
        for (ToDoItem toDoItem : toDoItemList) {

            ToDoItemDTO toDoItemDTO = new ToDoItemDTO(toDoItem.getName(),
                    toDoItem.getTargetDate(),
                    toDoItem.getStatus());

            toDoItemDTOList.add(toDoItemDTO);
        }

        return toDoItemDTOList;
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
