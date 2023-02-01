package com.example.testSpr.Model;

import com.example.testSpr.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;

    public User() {
    }
    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        return model;
    }
}
