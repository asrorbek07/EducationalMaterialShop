package com.example.educationalmaterialsshop.model.payload.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse{
    int id;
    Instant date;
    String name;
    double purchasePrice;
    double sellingPrice;
    String description;
    int allQuantity;
    int currentQuantity;
}
