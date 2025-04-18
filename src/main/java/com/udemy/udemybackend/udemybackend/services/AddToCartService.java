package com.udemy.udemybackend.udemybackend.services;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.Student;
import com.udemy.udemybackend.udemybackend.models.User;
import com.udemy.udemybackend.udemybackend.repositories.CourseRepository;
import com.udemy.udemybackend.udemybackend.repositories.StudentRepository;
import com.udemy.udemybackend.udemybackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AddToCartService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public AddToCartService(CourseRepository courseRepository, UserRepository userRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    public Course addToCart(Long userId,Long courseId){
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isEmpty()){
            throw new RuntimeException("Course Not Found!!");
        }
        Optional<Student> studentOptional = studentRepository.findById(userId);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("User Not Found!!");
        }
        Course course = courseOptional.get();
        course.setTotalEnrollments(course.getTotalEnrollments()+1);
        courseRepository.save(course);

        Student student = studentOptional.get();
        student.getCart().add(course);
        studentRepository.save(student);
        return course;
    }
}
