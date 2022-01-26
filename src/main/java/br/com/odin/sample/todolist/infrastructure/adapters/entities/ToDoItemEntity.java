package br.com.odin.sample.todolist.infrastructure.adapters.entities;

import br.com.odin.sample.todolist.domain.Status;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_todo_item")
public class ToDoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_item_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "target_date")
    private Date targetDate;

    @Column(name = "status")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private ToDoEntity toDoEntity;

    public ToDoItemEntity(String name, Long id, Date targetDate, Status status, ToDoEntity toDoEntity) {
        this.id = id;
        this.name = name;
        this.targetDate = targetDate;
        this.status = status;
        this.toDoEntity = toDoEntity;

    }

    public ToDoItemEntity() {

    }

    public Long getId() {
        return id;
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

    public ToDoEntity getToDoEntity() {
        return toDoEntity;
    }
}
