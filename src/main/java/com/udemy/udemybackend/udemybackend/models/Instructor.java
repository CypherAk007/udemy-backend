package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Instructor extends User{
    private int totalViews;
    @ManyToMany
    private List<Course> publishedCourses;
}
