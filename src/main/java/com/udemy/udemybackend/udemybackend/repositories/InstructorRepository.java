package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.Instructor;
import com.udemy.udemybackend.udemybackend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    Optional<Instructor> findByEmail(String email);
}
