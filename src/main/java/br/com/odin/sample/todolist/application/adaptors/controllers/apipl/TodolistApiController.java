package br.com.odin.sample.todolist.application.adaptors.controllers.apipl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-19T16:29:33.573349-02:00[America/Sao_Paulo]")

//@Controller
//@RequestMapping("${openapi.toDoList.base-path:/antoniocncj/poc/1.0.0}")
public class TodolistApiController implements TodolistApi {

    private final TodolistApiDelegate delegate;

    public TodolistApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) TodolistApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new TodolistApiDelegate() {});
    }

    @Override
    public TodolistApiDelegate getDelegate() {
        return delegate;
    }

}
