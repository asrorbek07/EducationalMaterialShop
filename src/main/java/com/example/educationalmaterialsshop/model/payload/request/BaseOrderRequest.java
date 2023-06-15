package com.example.educationalmaterialsshop.model.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseOrderRequest {
    int quantity;
    double purchasePrice;
    double sellingPrice;
}
