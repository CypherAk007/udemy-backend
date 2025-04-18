package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class CartRequestDTO {
    private Long courseId;
    private Long userId;
}
