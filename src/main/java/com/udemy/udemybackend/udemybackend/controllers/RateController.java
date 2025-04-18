package com.udemy.udemybackend.udemybackend.controllers;

import com.udemy.udemybackend.udemybackend.dtos.*;
import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.Rating;
import com.udemy.udemybackend.udemybackend.services.RatingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RateController {
    private final RatingService ratingService;

    public RateController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/course/{courseId}/addRating")
    @Tag(name = "Add Rating", description = "APIs for rating the course!!")
    public ResponseEntity<RatingResponseDTO> addRatingToCourse(RatingRequestDTO requestDTO){
        RatingResponseDTO responseDTO = new RatingResponseDTO();
        try{
            Rating rating =ratingService.addRatingToCourse(requestDTO.getUserId(), requestDTO.getCourseId(),requestDTO.getRating());
            responseDTO.setRatingId(rating.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Rating Added to course Successfully!!");
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Unable to add Rating to Course!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }
}
