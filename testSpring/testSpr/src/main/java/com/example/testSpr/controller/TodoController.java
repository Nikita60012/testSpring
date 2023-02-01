package com.example.testSpr.controller;

import com.example.testSpr.entity.TodoEntity;
import com.example.testSpr.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userid){
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userid));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Error!!");
        }
    }
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Error!!");
        }
    }
}
