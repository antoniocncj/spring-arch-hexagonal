package br.com.odin.sample.todolist.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * ToDoResponseDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T17:48:31.548787900-03:00[America/Sao_Paulo]")

public class ToDoResponseDTO   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("items")
  private List<ToDoListItemsResponseDTO> items;

    public ToDoResponseDTO(String name, List<ToDoListItemsResponseDTO> toDTO) {
      this.name = name;
      this.items = toDTO;
    }

    public ToDoResponseDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ToDoResponseDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "minha-lista-de-tarefas", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ToDoResponseDTO items(List<ToDoListItemsResponseDTO> items) {
    this.items = items;
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ToDoListItemsResponseDTO> getItems() {
    return items;
  }

  public void setItems(List<ToDoListItemsResponseDTO> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoResponseDTO toDoResponseDTO = (ToDoResponseDTO) o;
    return Objects.equals(this.id, toDoResponseDTO.id) &&
        Objects.equals(this.name, toDoResponseDTO.name) &&
        Objects.equals(this.items, toDoResponseDTO.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ToDoResponseDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

