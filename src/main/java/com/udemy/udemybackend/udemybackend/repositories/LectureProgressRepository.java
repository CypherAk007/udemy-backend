package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.Lecture;
import com.udemy.udemybackend.udemybackend.models.LectureProgress;
import com.udemy.udemybackend.udemybackend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureProgressRepository extends JpaRepository<LectureProgress,Long> {
    Optional<LectureProgress> findByStudentAndLecture(Student student, Lecture lecture);
}
