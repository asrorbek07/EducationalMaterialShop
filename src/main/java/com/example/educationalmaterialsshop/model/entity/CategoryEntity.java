package com.example.educationalmaterialsshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Builder
@Entity
public class CategoryEntity extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;

    public CategoryEntity(String name) {
        this.name = name;
    }
}
