package com.example.demo.repo;

import com.example.demo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDoItem, Long> {

}
