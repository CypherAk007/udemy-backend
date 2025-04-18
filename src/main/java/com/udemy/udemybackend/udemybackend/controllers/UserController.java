package com.udemy.udemybackend.udemybackend.controllers;

import com.udemy.udemybackend.udemybackend.dtos.*;
import com.udemy.udemybackend.udemybackend.models.Instructor;
import com.udemy.udemybackend.udemybackend.models.Student;
import com.udemy.udemybackend.udemybackend.models.User;
import com.udemy.udemybackend.udemybackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/student/signup")
    public ResponseEntity<SignUpResponseDTO> signupUser(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try {
            Student student = userService.signUpStudent(requestDTO.getName(),requestDTO.getEmail(),requestDTO.getPassword());
            responseDTO.setUserId(student.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User Signed up Successfully!!");
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User Sign Up Unsuccessful!!");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PostMapping("/instructor/signup")
    public ResponseEntity<SignUpResponseDTO> signupInstructor(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try {
            Instructor instructor = userService.signUpInstructor(requestDTO.getName(),requestDTO.getEmail(),requestDTO.getPassword());
            responseDTO.setUserId(instructor.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User Signed up Successfully!!");
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User Sign Up Unsuccessful!!");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PostMapping("/student/loginStudent")
    public ResponseEntity<LoginResponseDTO> loginStudent(LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try {
            Student student = userService.loginStudent(requestDTO.getEmail(),requestDTO.getPassword());
            responseDTO.setUserId(student.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User Signed up Successfully!!");
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User Sign Up Unsuccessful!!");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }

    @PostMapping("/instructor/loginInstructor")
    public ResponseEntity<LoginResponseDTO> loginInstructor(SignUpRequestDTO requestDTO){
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try {
            Instructor instructor = userService.loginInstructor(requestDTO.getEmail(),requestDTO.getPassword());
            responseDTO.setUserId(instructor.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User Signed up Successfully!!");
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("User Sign Up Unsuccessful!!");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }



}
