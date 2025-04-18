package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Course extends BaseModel{
    private String name;
    private String domain;
    private int totalEnrollments;
    private String description;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<CourseModule> modules = new ArrayList<>();;
    @ManyToMany
    private List<Instructor> instructors = new ArrayList<>();;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();;

}
