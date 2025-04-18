package com.udemy.udemybackend.udemybackend.services;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.Rating;
import com.udemy.udemybackend.udemybackend.models.Student;
import com.udemy.udemybackend.udemybackend.repositories.CourseRepository;
import com.udemy.udemybackend.udemybackend.repositories.RatingRepository;
import com.udemy.udemybackend.udemybackend.repositories.StudentRepository;
import com.udemy.udemybackend.udemybackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;


    public RatingService(RatingRepository ratingRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.ratingRepository = ratingRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Rating addRatingToCourse(Long studentId, Long courseId, Double rating){
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isEmpty()){
            throw new RuntimeException("Course Not Found!!");
        }
        Course course = courseOptional.get();
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("User Not Found!!");
        }
        Student student = studentOptional.get();

        Optional<Rating> ratingOptional = ratingRepository.findByStudentAndCourse(student,course);
        Rating ratingObj;
        if(ratingOptional.isEmpty()){
            ratingObj  = new Rating();
            ratingObj.setRating(rating);
            ratingObj.setCourse(course);
            ratingObj.setStudent(student);
            Rating savedRating = ratingRepository.save(ratingObj);
            course.getRatings().add(savedRating);
            courseRepository.save(course);
        }else{
            ratingObj = ratingOptional.get();
            ratingObj.setRating(rating);
            ratingObj = ratingRepository.save(ratingObj);

            Long ratingId  = ratingObj.getId();
            course.getRatings().removeIf(r->r.getId().equals(ratingId));
            course.getRatings().add(ratingObj);
            courseRepository.save(course);
        }

        return ratingObj;
    }
}
