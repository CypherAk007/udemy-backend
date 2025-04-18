package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private Long userId;
    private String message;
    private ResponseStatus responseStatus;
}
