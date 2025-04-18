package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Lecture extends BaseModel{
    private String name;
    private String duration;
    private String description;
    @ManyToOne
    private Instructor instructor;
    private String videoUrl;
    @ManyToOne
    @JoinColumn(name = "course_module")
    private CourseModule module;
    @ManyToMany
    private List<Material> attachments;
}
