package com.example.testSpr.service;

import com.example.testSpr.Model.User;
import com.example.testSpr.entity.UserEntity;
import com.example.testSpr.exceptions.UserAlreadyExistException;
import com.example.testSpr.exceptions.UserNotFoundException;
import com.example.testSpr.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Already exist!");
        }
        return userRepo.save(user);
    }
    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("doesn`t exist!");
        }
        return User.toModel(user);
    }
    public Long deleteUser(Long id){
      userRepo.deleteById(id);
      return id;
    }
}
