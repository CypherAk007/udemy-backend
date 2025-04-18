package com.udemy.udemybackend.udemybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Material extends BaseModel{
    @Enumerated(EnumType.STRING)
    private MaterialType materialType;
    private String url;
}
