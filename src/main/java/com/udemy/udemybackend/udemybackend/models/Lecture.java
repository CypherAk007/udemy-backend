package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

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
