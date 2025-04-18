package com.udemy.udemybackend.udemybackend.dtos;

import lombok.Data;

@Data
public class UploadLectureResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
    private Long lectureId;
}
