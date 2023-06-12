package com.example.educationalmaterialsshop.model.payload.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse extends BaseResponse {
    String name;
    double price;
    String description;
    int quantity;
    int isbn;
}
