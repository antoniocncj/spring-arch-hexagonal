package br.com.odin.sample.todolist.domain;

import br.com.odin.sample.todolist.shared.dtos.ToDoListItemsRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoListItemsResponseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoItem {

    private Long id;
    private String name;
    private Date targetDate;
    private Status status;
    private List<ToDoListItemsRequestDTO> toDoItemDTOList;

    public ToDoItem() {

    }

    public ToDoItem(List<ToDoListItemsRequestDTO> toDoItemDTOList) {
        this.toDoItemDTOList = toDoItemDTOList;
    }

    public ToDoItem(String name, Date targetDate, Status status) {
        this.name = name;
        this.targetDate = targetDate;
        this.status = status;
    }

    public ToDoItem(String name, Long id, Date targetDate, Status status) {
        this.id = id;
        this.name = name;
        this.targetDate = targetDate;
        this.status = status;
    }

    public List<ToDoItem> toObject() {

        List<ToDoItem> toDoItems = new ArrayList<>();
        for (ToDoListItemsRequestDTO toDoItemDTO : this.toDoItemDTOList) {

            ToDoItem toDoItem = new ToDoItem(toDoItemDTO.getName(),
                    toDoItemDTO.getTargetDate(),
                    Status.Backlog);

            toDoItems.add(toDoItem);
        }

        return toDoItems;
    }

    public List<ToDoListItemsResponseDTO> toDTO(List<ToDoItem> toDoItemList) {

        List<ToDoListItemsResponseDTO> toDoItemDTOList = new ArrayList<>();
        for (ToDoItem toDoItem : toDoItemList) {

            ToDoListItemsResponseDTO toDoItemDTO = new ToDoListItemsResponseDTO(toDoItem.getName(),
                    toDoItem.getId(),
                    toDoItem.getTargetDate(),
                    toDoItem.getStatus());

            toDoItemDTOList.add(toDoItemDTO);
        }

        return toDoItemDTOList;
    }

    public Long getId() {
        return this.id;
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
