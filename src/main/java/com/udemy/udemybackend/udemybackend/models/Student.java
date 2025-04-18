package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Student extends User{
    @ManyToMany
    private List<Course> enrolledCourses;
}
