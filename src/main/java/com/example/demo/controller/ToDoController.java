package com.example.demo.controller;

import com.example.demo.model.ToDoItem;
import com.example.demo.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
    @Autowired
    private ToDoRepo toDoRepo;

    @PostMapping
    public ToDoItem        save   (@RequestBody ToDoItem toDoItem)  { return toDoRepo.save(toDoItem); }//Create
    @GetMapping
    public List<ToDoItem>  findAll()                                { return toDoRepo.findAll(); }     //READ
    @PutMapping
    public ToDoItem        update (@RequestBody ToDoItem toDoItem)  { return toDoRepo.save(toDoItem); }//Update
    @DeleteMapping(value = "/{id}")
    public void            delete (@PathVariable Long id)           { toDoRepo.deleteById(id); }       //Delete
}
