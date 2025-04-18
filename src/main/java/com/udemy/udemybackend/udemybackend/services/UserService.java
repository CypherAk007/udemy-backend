package com.udemy.udemybackend.udemybackend.services;

import com.udemy.udemybackend.udemybackend.models.Instructor;
import com.udemy.udemybackend.udemybackend.models.Student;
import com.udemy.udemybackend.udemybackend.repositories.InstructorRepository;
import com.udemy.udemybackend.udemybackend.repositories.StudentRepository;
import com.udemy.udemybackend.udemybackend.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;

    public UserService(UserRepository userRepository, StudentRepository studentRepository, InstructorRepository instructorRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
    }

    public Student signUpStudent(String name,String email,String password){
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        student.setPassword(bCryptPasswordEncoder.encode(password));
        return studentRepository.save(student);
    }

    public Instructor signUpInstructor(String name,String email,String password){
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        instructor.setPassword(bCryptPasswordEncoder.encode(password));
        return instructorRepository.save(instructor);
    }

    public Student loginStudent(String email,String password) {
        Optional<Student> studentOptional = studentRepository.findByEmail(email);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Invalid Credentials!!");
        }
        Student student = studentOptional.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedpwd = student.getPassword();
        if (bCryptPasswordEncoder.matches(password, encodedpwd)) {
            return student;
        }
        throw new RuntimeException("Invalid Credentials!!");
    }

    public Instructor loginInstructor(String email,String password) {
        Optional<Instructor> instructorOptional = instructorRepository.findByEmail(email);
        if (instructorOptional.isEmpty()) {
            throw new RuntimeException("Invalid Credentials!!");
        }
        Instructor instructor = instructorOptional.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedpwd = instructor.getPassword();
        if (bCryptPasswordEncoder.matches(password, encodedpwd)) {
            return instructor;
        }
        throw new RuntimeException("Invalid Credentials!!");
    }
}
