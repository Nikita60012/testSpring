package com.example.testSpr.repository;

import com.example.testSpr.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
    UserEntity findByUsername(String username);
}
