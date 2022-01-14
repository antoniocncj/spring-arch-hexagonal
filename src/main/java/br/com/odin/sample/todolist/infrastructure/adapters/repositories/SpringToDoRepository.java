package br.com.odin.sample.todolist.infrastructure.adapters.repositories;

import br.com.odin.sample.todolist.infrastructure.adapters.entities.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
