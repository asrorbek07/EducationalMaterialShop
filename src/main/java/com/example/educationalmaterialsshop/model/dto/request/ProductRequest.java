package com.example.educationalmaterialsshop.model.dto.request;

import com.example.educationalmaterialsshop.model.entity.CategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
    private Integer ISBN;
    private Integer categoryId;
}
