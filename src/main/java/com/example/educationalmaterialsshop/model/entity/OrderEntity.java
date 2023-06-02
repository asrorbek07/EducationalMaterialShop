package com.example.educationalmaterialsshop.model.entity;

import com.example.educationalmaterialsshop.model.dto.request.OrderRequest;
import com.example.educationalmaterialsshop.model.dto.request.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderEntity extends BaseEntity{
    @OneToOne
    private UserEntity customer;
    @OneToOne
    private ProductEntity product;
    private Integer quantity;
    private Integer totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    public OrderEntity(OrderRequest orderRequest) {
        this.quantity = orderRequest.getQuantity();
        this.status = orderRequest.getStatus();
    }
}
