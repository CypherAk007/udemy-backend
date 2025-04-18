package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.CourseModule;
import com.udemy.udemybackend.udemybackend.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseModuleRepository extends JpaRepository<CourseModule,Long> {
    Optional<CourseModule> findByCourse(Course course);
}
