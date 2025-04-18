package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class CourseModule extends BaseModel{
    private String name;
    private String domain;
    private String description;
    @OneToMany
    private List<Lecture> lectures;
    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

}
