package br.com.odin.sample.todolist.domain.adaptors.services;

import br.com.odin.sample.todolist.application.adaptors.controllers.apipl.TodolistApiDelegate;
import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoResponseDTO;
import br.com.odin.sample.todolist.domain.ToDo;
import br.com.odin.sample.todolist.domain.ToDoItem;
import br.com.odin.sample.todolist.domain.ports.repository.ToDoRepositoryPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodolistApiDelegateServiceImpl implements TodolistApiDelegate {

    private final ToDoRepositoryPort toDoRepositoryPort;

    public TodolistApiDelegateServiceImpl(ToDoRepositoryPort toDoRepositoryPort ) {
        this.toDoRepositoryPort = toDoRepositoryPort;
    }

    @Override
    public ResponseEntity<List<ToDoResponseDTO>> getAllToDoList() {

        List<ToDo> toDoList =  this.toDoRepositoryPort.get();

        List<ToDoResponseDTO> toDoResponseDTOList = new ArrayList<>();

        for (ToDo toDo:toDoList ) {
            toDoResponseDTOList.add(new ToDoResponseDTO(toDo.getName(), toDo.getId(), new ToDoItem().toDTO(toDo.getToDoItem())));
        }


        return ResponseEntity.ok(toDoResponseDTOList);

    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Void> createToDoList(ToDoRequestDTO toDoRequestDTO) {
        return null;
    }


    @Override
    public ResponseEntity<ToDoResponseDTO> getToDoById(Long id) {
        return null;
    }
}
