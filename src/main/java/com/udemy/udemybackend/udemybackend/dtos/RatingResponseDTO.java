package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class RatingResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
    private Long ratingId;
}
