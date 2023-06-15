package com.example.educationalmaterialsshop.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Instant date;
    @ManyToOne
    Supplier supplier;
    @ManyToOne
    Product product;
    double price;
    int quantity;
    double totalPrice;
}
