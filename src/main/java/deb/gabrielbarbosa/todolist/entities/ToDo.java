package deb.gabrielbarbosa.todolist.entities;

import deb.gabrielbarbosa.todolist.dto.ToDoCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_to_do")
@Where(clause = "deleted_at IS NULL")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String toDo;
    private LocalDateTime done;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;

    public ToDo(ToDoCreateDTO toDoCreateDTO) {
        this.toDo = toDoCreateDTO.getToDo();
        this.done = null;
        this.deletedAt = null;
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }

}
