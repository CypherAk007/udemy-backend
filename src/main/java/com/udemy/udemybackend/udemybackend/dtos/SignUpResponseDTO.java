package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class SignUpResponseDTO {
    private Long userId;
    private String message;
    private ResponseStatus responseStatus;
}
