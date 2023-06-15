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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Instant date;
    String fullName;
    @Column(nullable = false, unique = true)
    String phoneNumber;
    @Column(nullable = false)
    String address;
    String company;
}
