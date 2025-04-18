package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Rating extends BaseModel{
    private Double rating;
    private String comment;
    @ManyToOne
    @JoinColumn(name="course")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;
}
