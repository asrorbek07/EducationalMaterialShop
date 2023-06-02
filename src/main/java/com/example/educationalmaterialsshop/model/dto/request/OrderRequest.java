package com.example.educationalmaterialsshop.model.dto.request;

import com.example.educationalmaterialsshop.model.entity.OrderStatusEnum;
import com.example.educationalmaterialsshop.model.entity.ProductEntity;
import com.example.educationalmaterialsshop.model.entity.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class OrderRequest {
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
    private OrderStatusEnum status;
}
