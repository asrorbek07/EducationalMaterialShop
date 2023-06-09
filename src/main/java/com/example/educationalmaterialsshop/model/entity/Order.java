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
@Entity(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Instant date;
    @ManyToOne
    Product product;
    int quantity;
    double purchasePrice;
    double sellingPrice;
    double profit;
}
