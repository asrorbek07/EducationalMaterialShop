package com.example.educationalmaterialsshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity{
    @Column(unique = true,nullable = false)
    String name;
    double price;
    @Column(nullable = false)
    String description;
    int quantity;
    @Column(nullable = false)
//    @Digits(integer = 13, fraction = 0)
    int isbn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;
}
