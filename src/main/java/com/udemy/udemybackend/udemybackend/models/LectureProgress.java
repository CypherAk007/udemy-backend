package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class LectureProgress extends BaseModel{
    @ManyToOne
    private Student student;
    @ManyToOne
    private Lecture lecture;
    private double watchedSeconds;
}
