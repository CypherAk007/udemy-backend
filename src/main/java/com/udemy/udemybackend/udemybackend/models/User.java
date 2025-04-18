package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // or SINGLE_TABLE / TABLE_PER_CLASS
public abstract class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
