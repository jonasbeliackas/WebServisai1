package com.example.demo.controller;

import com.example.demo.model.ToDoItem;
import com.example.demo.repo.ToDoRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ToDoRepo toDoRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ToDoItem> save(@RequestBody ToDoItem toDoItem) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location",
                "/todo");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(toDoRepo.save(toDoItem));
       // return toDoRepo.save(toDoItem);
    }//Create

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<ToDoItem>> findAll() {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location",
                "/todo");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(toDoRepo.findAll());
      // return toDoRepo.findAll();
    }//READ

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Optional<ToDoItem>> findByID(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location",
                "/todo/"+id);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(toDoRepo.findById(id));


        //return toDoRepo.findById(id);
    }//READ

    @PutMapping
    public ResponseEntity<ToDoItem> update(@RequestBody ToDoItem toDoItem) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location",
                "/todo");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(toDoRepo.save(toDoItem));
        //return toDoRepo.save(toDoItem);
    }//Update
    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDoItem> update(@PathVariable Long id,@RequestBody ToDoItem toDoItem) {
        ToDoItem item = toDoRepo.getOne(id);
        item.setTitle(toDoItem.getTitle());
        item.setDone(toDoItem.isDone());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location",
                "/todo/"+id);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(toDoRepo.save(item));
        //return toDoRepo.save(item);
    }//Update

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location",
                "/todo/"+id);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Deleted");
        //toDoRepo.deleteById(id);
    }//Delete
}
