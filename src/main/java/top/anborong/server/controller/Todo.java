package top.anborong.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.anborong.server.dataobject.TodoMaster;
import top.anborong.server.repository.TodoMasterRepository;

import java.util.List;

@RestController()
public class Todo {

    @Autowired
    private TodoMasterRepository repository;

    @GetMapping("/todo")
    public List<TodoMaster> getTodos() {
        return repository.findAll();
    }

    @PostMapping("/todo")
    public TodoMaster saveTodo(@RequestBody TodoMaster todoMaster) {
        return repository.save(todoMaster);
    }
}
