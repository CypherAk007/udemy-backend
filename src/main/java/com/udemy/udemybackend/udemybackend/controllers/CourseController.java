package com.udemy.udemybackend.udemybackend.controllers;

import com.udemy.udemybackend.udemybackend.dtos.CourseResponseDTO;
import com.udemy.udemybackend.udemybackend.dtos.ResponseStatus;
import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.CourseModule;
import com.udemy.udemybackend.udemybackend.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructor")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/{instructorId}")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestParam("courseName") String courseName,
                                                          @RequestParam("domain") String domain,
                                                          @RequestParam("description")String description,
                                                          @PathVariable Long instructorId){
        CourseResponseDTO responseDTO = new CourseResponseDTO();
        try{
            Course course = courseService.createCourse(courseName,domain,description,instructorId);
            responseDTO.setCourseId(course.getId());
            responseDTO.setMessage("Created Course Successfully!!");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDTO);

        }catch (Exception e){
            responseDTO.setMessage("Course Creation UnSuccessful!!" + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }


    @PostMapping("/{instructorId}/courses/{courseId}/createModule/")
    public ResponseEntity<CourseResponseDTO> createCourseModule(@RequestParam("moduleName") String courseModuleName,
                                                          @RequestParam("description")String description,
                                                          @PathVariable Long courseId,
                                                          @PathVariable Long instructorId){
        CourseResponseDTO responseDTO = new CourseResponseDTO();
        try{
            CourseModule courseModule = courseService.createCourseModule(courseId,courseModuleName,description,instructorId);
            responseDTO.setCourseId(courseModule.getId());
            responseDTO.setMessage("Created courseModule Successfully!!");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(responseDTO);

        }catch (Exception e){
            responseDTO.setMessage("courseModule Creation UnSuccessful!!" + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }
}
