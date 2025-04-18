package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class CourseResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
    private Long courseId;
}
