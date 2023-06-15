package com.example.educationalmaterialsshop.model.payload.response;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplierResponse {
    int id;
    Instant date;
    String fullName;
    String phoneNumber;
    String address;
    String company;
}
