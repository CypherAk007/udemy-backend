package com.udemy.udemybackend.udemybackend.controllers;

import com.udemy.udemybackend.udemybackend.dtos.LectureProgressResponseDTO;
import com.udemy.udemybackend.udemybackend.dtos.ResponseStatus;
import com.udemy.udemybackend.udemybackend.models.LectureProgress;
import com.udemy.udemybackend.udemybackend.services.LectureProgressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses/{courseId}")
public class LectureProgressController {
    public final LectureProgressService lectureProgressService;

    public LectureProgressController(LectureProgressService lectureProgressService) {
        this.lectureProgressService = lectureProgressService;
    }

    @PostMapping("/lectures/{lectureId}/updateProgress")
    public ResponseEntity<LectureProgressResponseDTO> updateLectureProgress(@PathVariable Long lectureId,
                                                                            @RequestParam("studentId") Long studentId,
                                                                            @RequestParam("watchedSeconds") Double watchedSeconds){
        LectureProgressResponseDTO responseDTO = new LectureProgressResponseDTO();
        try {
            LectureProgress lectureProgress = lectureProgressService.updateLectureProgress(studentId,lectureId,watchedSeconds);
            responseDTO.setLectureProgressId(lectureProgress.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Lecture Progress Updated Successfully!!");
            return ResponseEntity.ok(responseDTO);

        } catch (Exception e) {

            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Unable to update Lecture Progress!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }

    }

    @GetMapping("/lectures/{lectureId}/getProgress")
    public ResponseEntity<Double> getLectureProgress(@PathVariable Long lectureId,
                                                                            @RequestParam("studentId") Long studentId
                                                                            ){
        try {
            Double watchedSeconds = lectureProgressService.getLectureProgress(studentId,lectureId);
            return ResponseEntity.ok(watchedSeconds);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0.0);
        }

    }
}
