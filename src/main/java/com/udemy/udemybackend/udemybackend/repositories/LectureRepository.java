package com.udemy.udemybackend.udemybackend.repositories;

import com.udemy.udemybackend.udemybackend.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Long> {
}
