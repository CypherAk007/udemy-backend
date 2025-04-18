package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class CourseModule extends BaseModel{
    private String name;
    private String description;
    @OneToMany
    private List<Lecture> lectures = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

}
