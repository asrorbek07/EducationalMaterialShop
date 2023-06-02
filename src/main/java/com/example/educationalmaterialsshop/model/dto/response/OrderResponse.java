package com.example.educationalmaterialsshop.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {
    private Integer customer;
    private Integer productId;
    private Integer quantity;
    private String status;
}
