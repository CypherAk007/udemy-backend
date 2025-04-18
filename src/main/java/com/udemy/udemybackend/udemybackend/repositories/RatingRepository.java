package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.Rating;
import com.udemy.udemybackend.udemybackend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
    Optional<Rating> findByStudentAndCourse(Student student, Course course);
}
