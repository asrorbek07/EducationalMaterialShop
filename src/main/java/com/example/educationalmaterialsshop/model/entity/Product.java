package com.example.educationalmaterialsshop.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Instant date;
    @Column(unique = true,nullable = false)
    String name;
    double purchasePrice;
    double sellingPrice;
    @Column(nullable = false)
    String description;
    int allQuantity;
    int currentQuantity;
}
