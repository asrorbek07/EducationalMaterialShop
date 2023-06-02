package com.example.educationalmaterialsshop.model.dto.response;

import com.example.educationalmaterialsshop.model.entity.CategoryEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private String name;
    private Double price;
    private String description;
    private Integer quantity;
    private Integer ISBN;
    private Integer categoryId;
}
