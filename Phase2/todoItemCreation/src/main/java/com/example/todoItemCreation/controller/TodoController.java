package com.example.todoItemCreation.controller;

import com.example.todoItemCreation.model.Item;
import com.example.todoItemCreation.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService toDoService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Item> findAll(){
        return toDoService.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id){
        return toDoService.findById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public Item create(@RequestBody Item item){
        return toDoService.save(item);
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public Item update(@RequestBody Item item){
        return toDoService.save(item);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping
    public void deleteById(@PathVariable Integer id){
        toDoService.deleteById(id);
    }
}
