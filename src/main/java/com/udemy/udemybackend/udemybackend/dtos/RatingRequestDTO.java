package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class RatingRequestDTO {
    private Long courseId;
    private Long userId;
    private Double rating;
}
