package br.com.odin.sample.todolist.shared.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * ToDoListItemsRequestDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T17:48:31.548787900-03:00[America/Sao_Paulo]")

public class ToDoListItemsRequestDTO   {

  @JsonProperty("name")
  private String name;

  @JsonProperty("targetDate")
  private Date targetDate;

  public ToDoListItemsRequestDTO name(String name) {
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

  public ToDoListItemsRequestDTO targetDate(Date targetDate) {
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
    SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    try {
     String date =   simpleDateFormat.format(this.targetDate);

     return simpleDateFormat.parse(date);

    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;

    //return new Date(dateFormat.format(this.targetDate));
  }

  public void setTargetDate(Date targetDate) {
    this.targetDate = targetDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToDoListItemsRequestDTO toDoListItemsRequestDTO = (ToDoListItemsRequestDTO) o;
    return Objects.equals(this.name, toDoListItemsRequestDTO.name) &&
        Objects.equals(this.targetDate, toDoListItemsRequestDTO.targetDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, targetDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ToDoListItemsRequestDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    targetDate: ").append(toIndentedString(targetDate)).append("\n");
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

