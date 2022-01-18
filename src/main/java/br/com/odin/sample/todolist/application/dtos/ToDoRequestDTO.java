package br.com.odin.sample.todolist.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ToDoRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T17:48:31.548787900-03:00[America/Sao_Paulo]")

public class ToDoRequestDTO   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("items")
  @Valid
  private List<ToDoListItemsRequestDTO> items = null;

  public ToDoRequestDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "minha-lista-de-tarefas", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ToDoRequestDTO items(List<ToDoListItemsRequestDTO> items) {
    this.items = items;
    return this;
  }

  public ToDoRequestDTO addItemsItem(ToDoListItemsRequestDTO itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ToDoListItemsRequestDTO> getItems() {
    return items;
  }

  public void setItems(List<ToDoListItemsRequestDTO> items) {
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
    ToDoRequestDTO toDoRequestDTO = (ToDoRequestDTO) o;
    return Objects.equals(this.name, toDoRequestDTO.name) &&
        Objects.equals(this.items, toDoRequestDTO.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ToDoRequestDTO {\n");
    
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

