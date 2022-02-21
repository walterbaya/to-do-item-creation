package com.example.todoapplication.controller;

import com.example.todoapplication.model.Item;
import com.example.todoapplication.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<Item> findAll(){
        return toDoService.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id){
        return toDoService.findById(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item){
        return toDoService.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@RequestBody Item item){
        return toDoService.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        toDoService.deleteById(id);
    }
}
