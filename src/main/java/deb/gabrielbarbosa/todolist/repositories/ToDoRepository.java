package deb.gabrielbarbosa.todolist.repositories;

import deb.gabrielbarbosa.todolist.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
