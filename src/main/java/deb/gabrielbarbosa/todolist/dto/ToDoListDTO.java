package deb.gabrielbarbosa.todolist.dto;

import deb.gabrielbarbosa.todolist.entities.ToDo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ToDoListDTO {

    private Long id;
    private String toDo;
    private LocalDateTime done;
    private LocalDateTime createdAt;

    public ToDoListDTO(ToDo toDo) {
        this.id = toDo.getId();
        this.toDo = toDo.getToDo();
        this.done = toDo.getDone();
        this.createdAt = toDo.getCreatedAt();
    }

}
