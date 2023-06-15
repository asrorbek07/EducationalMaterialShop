package com.example.educationalmaterialsshop.model.payload.request;

import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.entity.Supplier;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseInputRequest {
    double price;
    int quantity;
}
