package br.com.odin.sample.todolist.application.adaptors.controllers.apisw;

import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoResponseDTO;
import br.com.odin.sample.todolist.domain.ports.interfaces.ToDoServicePort;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodolistApiController implements TodolistApi {

    private final ToDoServicePort toDoServicePort;

    public TodolistApiController(ToDoServicePort toDoServicePort) {
        this.toDoServicePort = toDoServicePort;
    }


    @Override
    public ResponseEntity<Void> createToDoList(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) ToDoRequestDTO toDoRequestDTO) {

        toDoServicePort.add(toDoRequestDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ToDoResponseDTO>> getAllToDoList() {
        return new ResponseEntity<List<ToDoResponseDTO>>(HttpStatus.OK).ok(toDoServicePort.get());
    }

    @Override
    public ResponseEntity<ToDoResponseDTO> getToDoById(Long id) {
        return new ResponseEntity<List<ToDoResponseDTO>>(HttpStatus.OK).ok(toDoServicePort.get(id));
    }


}
