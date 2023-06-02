package com.example.educationalmaterialsshop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import lombok.*;
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class ProductEntity extends BaseEntity{
    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false, unique = true)
    @Digits(integer = 13, fraction = 0)
    private Integer ISBN;
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;
}
