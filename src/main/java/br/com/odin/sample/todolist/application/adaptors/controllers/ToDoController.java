package br.com.odin.sample.todolist.application.adaptors.controllers;

import br.com.odin.sample.todolist.application.adaptors.controllers.api.TodolistApi;
import br.com.odin.sample.todolist.application.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.application.dtos.ToDoResponseDTO;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("todolist")
public class ToDoController implements TodolistApi {

    private final ToDoServicePort toDoServicePort;

    public ToDoController(ToDoServicePort toDoServicePort) {
        this.toDoServicePort = toDoServicePort;
    }

    @PostMapping
    private void create(@RequestBody ToDoRequestDTO toDoDTO) {
        this.toDoServicePort.add(toDoDTO);
    }

    @GetMapping(value = "/{idToDo}")
    private ToDoResponseDTO retrieve(@PathVariable Long idToDo) {
        return this.toDoServicePort.get(idToDo);
    }


    @Override
    public ResponseEntity<Void> createToDoList(ToDoRequestDTO toDoRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<ToDoResponseDTO>> getAllToDoList() {
        return null;
    }

    @Override
    public ResponseEntity<ToDoResponseDTO> getToDoById(Long id) {
        return null;
    }
}
