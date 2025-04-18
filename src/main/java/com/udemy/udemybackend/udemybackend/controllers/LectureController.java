package com.udemy.udemybackend.udemybackend.controllers;

import com.udemy.udemybackend.udemybackend.dtos.ResponseStatus;
import com.udemy.udemybackend.udemybackend.dtos.UploadLectureResponseDTO;
import com.udemy.udemybackend.udemybackend.models.Lecture;
import com.udemy.udemybackend.udemybackend.services.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/instructor/{instructorId}/courses/{courseId}")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping(value = "/modules/{moduleId}/lectures",
                consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UploadLectureResponseDTO> uploadLecture(@PathVariable Long instructorId,
                                                                  @PathVariable Long courseId,
                                                                  @PathVariable Long moduleId,
                                                                  @RequestParam("name") String name,
                                                                  @RequestParam("duration") String duration,
                                                                  @RequestParam("description") String description,
                                                                  @RequestPart("video")MultipartFile vidoFile){
        UploadLectureResponseDTO uploadLectureResponseDTO = new UploadLectureResponseDTO();
        try{
            Lecture lecture = lectureService.uploadLecture(name,description,duration,instructorId,courseId,moduleId,vidoFile);
            uploadLectureResponseDTO.setLectureId(lecture.getId());
            uploadLectureResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            uploadLectureResponseDTO.setMessage("Lecture Uploaded successfully!!");
            return ResponseEntity.ok(uploadLectureResponseDTO);
        } catch (Exception e) {
            uploadLectureResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            uploadLectureResponseDTO.setMessage("Lecture Failed to Upload!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(uploadLectureResponseDTO);
        }
    }
}
