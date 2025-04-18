package com.udemy.udemybackend.udemybackend.services;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.CourseModule;
import com.udemy.udemybackend.udemybackend.models.Instructor;
import com.udemy.udemybackend.udemybackend.models.Lecture;
import com.udemy.udemybackend.udemybackend.repositories.CourseModuleRepository;
import com.udemy.udemybackend.udemybackend.repositories.CourseRepository;
import com.udemy.udemybackend.udemybackend.repositories.InstructorRepository;
import com.udemy.udemybackend.udemybackend.repositories.LectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class LectureService {
    private static final String VIDEO_DIRECTORY = "/Users/abhishekkrishna/Desktop/";
    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseModuleRepository courseModuleRepository;

    public LectureService(LectureRepository lectureRepository, CourseRepository courseRepository, InstructorRepository instructorRepository, CourseModuleRepository courseModuleRepository) {
        this.lectureRepository = lectureRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.courseModuleRepository = courseModuleRepository;
    }

    public Lecture uploadLecture(String name, String description, String duration, Long instructorId, Long courseId, Long moduleId, MultipartFile videoFile) throws IOException {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        if(instructorOptional.isEmpty()){
            throw new RuntimeException("Instructor not registered!! Please Signup!!");
        }
        Instructor instructor = instructorOptional.get();

        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isEmpty()){
            throw new RuntimeException("Course Not Found!!");
        }
        Course course = courseOptional.get();

        Optional<CourseModule> courseModuleOptional = courseModuleRepository.findByCourse(course);
        if(courseModuleOptional.isEmpty()){
            throw new RuntimeException("CourseModule Not Created by Instructor!!");
        }
        CourseModule courseModule = courseModuleOptional.get();

        String fileName = System.currentTimeMillis()+"_"+videoFile.getOriginalFilename();
        Path filePath = Paths.get(VIDEO_DIRECTORY+fileName);
        Files.copy(videoFile.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);

        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setDescription(description);
        lecture.setDuration(duration);
        lecture.setVideoUrl(filePath.toString());
        lecture.setModule(courseModule);
        lecture.setInstructor(instructor);
        return lectureRepository.save(lecture);
    }
}
