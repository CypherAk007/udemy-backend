package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class LectureProgressResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
    private Long lectureProgressId;
}
