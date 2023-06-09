package com.example.educationalmaterialsshop.model.payload.response;

import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse{
    int id;
    Instant date;
    ProductResponse productResponse;
    int quantity;
    double purchasePrice;
    double sellingPrice;
    double profit;
}
