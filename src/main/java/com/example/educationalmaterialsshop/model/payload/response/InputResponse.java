package com.example.educationalmaterialsshop.model.payload.response;

import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.entity.Supplier;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InputResponse {
    int id;
    Instant date;
    SupplierResponse supplierResponse;
    ProductResponse productResponse;
    double price;
    int quantity;
    double totalPrice;
}
