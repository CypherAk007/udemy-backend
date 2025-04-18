package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class CartResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
    private Long courseId;
}
