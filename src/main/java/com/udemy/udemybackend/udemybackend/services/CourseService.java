package com.udemy.udemybackend.udemybackend.services;

import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.models.CourseModule;
import com.udemy.udemybackend.udemybackend.models.Instructor;
import com.udemy.udemybackend.udemybackend.repositories.CourseModuleRepository;
import com.udemy.udemybackend.udemybackend.repositories.CourseRepository;
import com.udemy.udemybackend.udemybackend.repositories.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final CourseModuleRepository courseModuleRepository;

    public CourseService(InstructorRepository instructorRepository, CourseRepository courseRepository, CourseModuleRepository courseModuleRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
        this.courseModuleRepository = courseModuleRepository;
    }

    public Course createCourse(String courseName, String domain, String description,Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        if(instructorOptional.isEmpty()){
            throw new RuntimeException("Instructor not registered!! Please Signup!!");
        }
        Instructor instructor = instructorOptional.get();

        Optional<Course> courseOptional = courseRepository.findByNameAndInstructor(courseName,instructor);
        if(courseOptional.isPresent()){
            throw new RuntimeException("Course Already Created by Instructor!!");
        }
        Course course = new Course();
        course.setName(courseName);
        course.setDomain(domain);
        course.setDescription(description);
        course.getInstructors().add(instructor);
        return courseRepository.save(course);
    }

    public CourseModule createCourseModule(Long courseId,String moduleName, String description, Long instructorId) {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructorId);
        if(instructorOptional.isEmpty()){
            throw new RuntimeException("Instructor not registered!! Please Signup!!");
        }
        Instructor instructor = instructorOptional.get();

        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(courseOptional.isEmpty()){
            throw new RuntimeException("Course not registered!! Please Signup!!");
        }
        Course course = courseOptional.get();

        Optional<CourseModule> courseModuleOptional = courseModuleRepository.findByCourse(course);
        if(courseModuleOptional.isPresent()){
            throw new RuntimeException("CourseModule Already Created by Instructor!!");
        }
        CourseModule courseModule = new CourseModule();
        courseModule.setName(moduleName);
        courseModule.setDescription(description);
        courseModule.setCourse(course);
        return courseModuleRepository.save(courseModule);
    }
}
