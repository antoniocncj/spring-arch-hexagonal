package br.com.odin.sample.todolist.application.dtos;

import br.com.odin.sample.todolist.domain.Status;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * ToDoListItemsResponseDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T17:48:31.548787900-03:00[America/Sao_Paulo]")

public class ToDoListItemsResponseDTO   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("targetDate")
  private Date targetDate;

  @JsonProperty("status")
  private Status status;

  public ToDoListItemsResponseDTO(String name, Date targetDate, Status status) {
    this.name = name;
    this.targetDate = targetDate;
    this.status = status;
  }

  public ToDoListItemsResponseDTO id(Integer id) {
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

  public ToDoListItemsResponseDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "pagar-conta-de-luz ou fazer-bolo-aniversario", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ToDoListItemsResponseDTO targetDate(Date targetDate) {
    this.targetDate = targetDate;
    return this;
  }

  /**
   * Get targetDate
   * @return targetDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public Date getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(Date targetDate) {
    this.targetDate = targetDate;
  }

  public ToDoListItemsResponseDTO status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @ApiModelProperty(value = "")


  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoListItemsResponseDTO toDoListItemsResponseDTO = (ToDoListItemsResponseDTO) o;
    return Objects.equals(this.id, toDoListItemsResponseDTO.id) &&
        Objects.equals(this.name, toDoListItemsResponseDTO.name) &&
        Objects.equals(this.targetDate, toDoListItemsResponseDTO.targetDate) &&
        Objects.equals(this.status, toDoListItemsResponseDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, targetDate, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ToDoListItemsResponseDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    targetDate: ").append(toIndentedString(targetDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

