package com.udemy.udemybackend.udemybackend.services;

import com.udemy.udemybackend.udemybackend.models.Lecture;
import com.udemy.udemybackend.udemybackend.models.LectureProgress;
import com.udemy.udemybackend.udemybackend.models.Student;
import com.udemy.udemybackend.udemybackend.repositories.LectureProgressRepository;
import com.udemy.udemybackend.udemybackend.repositories.LectureRepository;
import com.udemy.udemybackend.udemybackend.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LectureProgressService {
    private final LectureProgressRepository lectureProgressRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    public LectureProgressService(LectureProgressRepository lectureProgressRepository, StudentRepository studentRepository, LectureRepository lectureRepository) {
        this.lectureProgressRepository = lectureProgressRepository;
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    public LectureProgress updateLectureProgress(Long studentId,Long lectureId,Double watchedSeconds){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("User Not Found!!");
        }
        Student student = studentOptional.get();

        Optional<Lecture> lectureOptional = lectureRepository.findById(lectureId);
        if(lectureOptional.isEmpty()){
            throw new RuntimeException("Lecture Not Found!!");
        }
        Lecture lecture = lectureOptional.get();

        Optional<LectureProgress> lectureProgressOptional = lectureProgressRepository.findByStudentAndLecture(student,lecture);
        if(lectureProgressOptional.isPresent()){
            LectureProgress lectureProgress =lectureProgressOptional.get();
            lectureProgress.setWatchedSeconds(watchedSeconds);
            return lectureProgressRepository.save(lectureProgress);
        }else {
            LectureProgress lectureProgress = new LectureProgress();
            lectureProgress.setLecture(lecture);
            lectureProgress.setStudent(student);
            lectureProgress.setWatchedSeconds(watchedSeconds);
            return lectureProgressRepository.save(lectureProgress);
        }
    }

    public Double getLectureProgress(Long studentId,Long lectureId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new RuntimeException("User Not Found!!");
        }
        Student student = studentOptional.get();

        Optional<Lecture> lectureOptional = lectureRepository.findById(lectureId);
        if(lectureOptional.isEmpty()){
            throw new RuntimeException("Lecture Not Found!!");
        }
        Lecture lecture = lectureOptional.get();

        Optional<LectureProgress> lectureProgressOptional = lectureProgressRepository.findByStudentAndLecture(student,lecture);
        return lectureProgressOptional.map(LectureProgress::getWatchedSeconds).orElse(0.0);
    }
}
