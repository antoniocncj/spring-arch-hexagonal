package br.com.odin.sample.todolist.application.adaptors.controllers.apipl;

import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import br.com.odin.sample.todolist.shared.dtos.ToDoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link TodolistApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-19T16:29:33.573349-02:00[America/Sao_Paulo]")

public interface TodolistApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /todolist : Cria uma nova lista de tarefas
     *
     * @param toDoRequestDTO  (optional)
     * @return Input inválido. (status code 405)
     * @see TodolistApi#createToDoList
     */
    default ResponseEntity<Void> createToDoList(ToDoRequestDTO toDoRequestDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /todolist/all : Busca todas as listas de tarefas.
     * retorna um array de lista de tarefas
     *
     * @return Sucesso (status code 200)
     *         or Id fornceido inválido (status code 400)
     *         or Registro não encontrado (status code 404)
     * @see TodolistApi#getAllToDoList
     */
    default ResponseEntity<List<ToDoResponseDTO>> getAllToDoList() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"minha-lista-de-tarefas\", \"id\" : 0, \"items\" : { \"targetDate\" : \"2000-01-23\", \"name\" : \"pagar-conta-de-luz ou fazer-bolo-aniversario\", \"id\" : 6, \"status\" : \"Backlog\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>123</id> <name>minha-lista-de-tarefas</name> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /todolist/{id} : Busca uma lista de tarefas pelo id
     * retorna uma lista de tarefas
     *
     * @param id identificador único da lista de tarefas (required)
     * @return Sucesso (status code 200)
     *         or Id fornceido inválido (status code 400)
     *         or Registro não encontrado (status code 404)
     * @see TodolistApi#getToDoById
     */
    default ResponseEntity<ToDoResponseDTO> getToDoById(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"minha-lista-de-tarefas\", \"id\" : 0, \"items\" : { \"targetDate\" : \"2000-01-23\", \"name\" : \"pagar-conta-de-luz ou fazer-bolo-aniversario\", \"id\" : 6, \"status\" : \"Backlog\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <id>123</id> <name>minha-lista-de-tarefas</name> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
