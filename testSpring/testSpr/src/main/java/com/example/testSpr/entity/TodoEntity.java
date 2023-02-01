package com.example.testSpr.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;
    private String title;
    private boolean completed;

    public boolean getCompleted() {
        return completed;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
