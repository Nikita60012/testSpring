package com.example.testSpr.controller;

import com.example.testSpr.entity.UserEntity;
import com.example.testSpr.exceptions.UserAlreadyExistException;
import com.example.testSpr.exceptions.UserNotFoundException;
import com.example.testSpr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("зарегестрирован");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Error!!");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Error!!!");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Error!!!");
        }
    }
}
