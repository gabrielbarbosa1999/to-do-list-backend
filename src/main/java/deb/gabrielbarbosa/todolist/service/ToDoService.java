package deb.gabrielbarbosa.todolist.service;

import deb.gabrielbarbosa.todolist.dto.ToDoCreateDTO;
import deb.gabrielbarbosa.todolist.dto.ToDoListDTO;
import deb.gabrielbarbosa.todolist.entities.ToDo;
import deb.gabrielbarbosa.todolist.repositories.ToDoRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public void create(ToDoCreateDTO toDoCreateDTO) {
        ToDo toDo = new ToDo(toDoCreateDTO);
        toDoRepository.save(toDo);
    }

    @Transactional(readOnly = true)
    public List<ToDoListDTO> findAll() {
        List<ToDo> toDos = toDoRepository.findAll(Sort.by("createdAt"));
        return toDos.stream()
                .map(ToDoListDTO::new)
                .collect(Collectors.toList());
    }

    public void delete(Long toDoId) {
        ToDo toDo = toDoRepository.findById(toDoId).orElseThrow(EntityExistsException::new);
        toDo.delete();
        toDoRepository.save(toDo);
    }

    public void done(Long toDoId) {
        ToDo toDo = toDoRepository.findById(toDoId).orElseThrow(EntityExistsException::new);
        toDo.done();
        toDoRepository.save(toDo);
    }

}
