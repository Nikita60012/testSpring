package com.example.testSpr.service;

import com.example.testSpr.entity.TodoEntity;
import com.example.testSpr.entity.UserEntity;
import com.example.testSpr.repository.TodoRepo;
import com.example.testSpr.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;
    public TodoEntity createTodo(TodoEntity todo, Long userid){
        UserEntity user = userRepo.findById(userid).get();
        todo.setUser(user);
        return todoRepo.save(todo);
    }
    public TodoEntity completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return todoRepo.save(todo);
    }
}
