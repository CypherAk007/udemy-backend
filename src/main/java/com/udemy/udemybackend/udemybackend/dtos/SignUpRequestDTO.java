package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String name;
    private String email;
    private boolean isInstructor;
    private String password;
}
