package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.CourseModule;
import com.udemy.udemybackend.udemybackend.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("SELECT c FROM Course c JOIN c.instructors i WHERE c.name=:courseName AND i=:instructor")
    Optional<Course> findByNameAndInstructor(@Param("courseName") String courseName,@Param("instructor") Instructor instructor);
}