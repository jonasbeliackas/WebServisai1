package com.example.demo.controller;

import com.example.demo.model.ToDoItem;
import com.example.demo.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
    @Autowired
    private ToDoRepo toDoRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItem save(@RequestBody ToDoItem toDoItem) {
        return toDoRepo.save(toDoItem);
    }//Create

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ToDoItem> findAll() {
        return toDoRepo.findAll();
    }//READ

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<ToDoItem> findByID(@PathVariable Long id) {

        return toDoRepo.findById(id);
    }//READ

    @PutMapping
    public ToDoItem update(@RequestBody ToDoItem toDoItem) {
        return toDoRepo.save(toDoItem);
    }//Update
    @PutMapping(value = "/{id}")
    public ToDoItem update(@PathVariable Long id,@RequestBody ToDoItem toDoItem) {
        ToDoItem item = toDoRepo.getOne(id);
        item.setTitle(toDoItem.getTitle());
        item.setDone(toDoItem.isDone());
        return toDoRepo.save(item);
    }//Update

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void delete(@PathVariable Long id) {
        toDoRepo.deleteById(id);
    }//Delete
}
