package br.com.odin.sample.todolist.infrastructure.adapters.entities;

import br.com.odin.sample.todolist.domain.ToDoItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_todo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "toDoEntity", cascade = CascadeType.ALL,fetch=FetchType.LAZY )
    private List<ToDoItemEntity> toDoItemEntity;

    public ToDoEntity(String name) {
        this.name = name;
    }

    public ToDoEntity() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setToDoItemEntity(List<ToDoItem> toDoItemList) {

        this.toDoItemEntity = new ArrayList<>();
        for (ToDoItem toDoItem : toDoItemList) {

            ToDoItemEntity toDoItemEntity = new ToDoItemEntity(toDoItem.getName(),
                    toDoItem.getId(),
                    toDoItem.getTargetDate(),
                    toDoItem.getStatus(),
                    this);

            this.toDoItemEntity.add(toDoItemEntity);
        }
    }

    public List<ToDoItem> getToDoItem() {

        List<ToDoItem> toDoItemList = new ArrayList<>();
        for (ToDoItemEntity toDoItemEntity : toDoItemEntity) {

            ToDoItem toDoItem = new ToDoItem(toDoItemEntity.getName(),
                    toDoItemEntity.getId(),
                    toDoItemEntity.getTargetDate(),
                    toDoItemEntity.getStatus());

            toDoItemList.add(toDoItem);
        }

        return toDoItemList;
    }
}
