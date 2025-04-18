package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class Instructor extends User{
    private int totalViews;
    @ManyToMany
    private List<Course> publishedCourses;
}
