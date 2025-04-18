package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Material extends BaseModel{
    @Enumerated(EnumType.STRING)
    private MaterialType materialType;
    private String url;
}
