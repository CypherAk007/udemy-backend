package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Course extends BaseModel{
    private String name;
    private String domain;
    private int totalEnrollments;
    private String description;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<CourseModule> modules;
    @ManyToMany
    private List<Instructor> instructors;
    @OneToMany
    private List<Rating> ratings;

}
