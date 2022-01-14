package br.com.odin.sample.todolist.application.adaptors.controllers;

import br.com.odin.sample.todolist.domain.dtos.ToDoDTO;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todolist")
public class ToDoController {

    private final ToDoServicePort toDoServicePort;

    public ToDoController(ToDoServicePort toDoServicePort) {
        this.toDoServicePort = toDoServicePort;
    }

    @PostMapping
    private void create(@RequestBody ToDoDTO toDoDTO) {
        this.toDoServicePort.add(toDoDTO);
    }

    @GetMapping(value = "/{idToDo}")
    private ToDoDTO retrieve(@PathVariable Long idToDo) {
        return this.toDoServicePort.get(idToDo);
    }


}
