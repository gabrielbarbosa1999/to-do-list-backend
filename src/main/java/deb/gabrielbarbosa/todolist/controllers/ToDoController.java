package deb.gabrielbarbosa.todolist.controllers;

import deb.gabrielbarbosa.todolist.dto.ToDoCreateDTO;
import deb.gabrielbarbosa.todolist.dto.ToDoListDTO;
import deb.gabrielbarbosa.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to-dos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public void create(@RequestBody ToDoCreateDTO toDoCreateDTO) {
        toDoService.create(toDoCreateDTO);
    }

    @GetMapping
    public List<ToDoListDTO> findAll() {
        return toDoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        toDoService.delete(id);
    }

    @PutMapping("/{id}")
    public void done(@PathVariable Long id) {
        toDoService.done(id);
    }

}
