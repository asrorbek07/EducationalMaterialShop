package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Category;
import com.example.educationalmaterialsshop.model.entity.Order;
import com.example.educationalmaterialsshop.model.entity.OrderItem;
import com.example.educationalmaterialsshop.model.payload.request.BaseCategoryRequest;
import com.example.educationalmaterialsshop.model.payload.request.OrderCreateRequest;
import com.example.educationalmaterialsshop.model.payload.request.OrderItemRequest;
import com.example.educationalmaterialsshop.model.payload.request.OrderUpdateRequest;
import com.example.educationalmaterialsshop.model.payload.response.CategoryResponse;
import com.example.educationalmaterialsshop.model.payload.response.OrderItemResponse;
import com.example.educationalmaterialsshop.model.payload.response.OrderResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderConverter {

    public OrderResponse from(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomer().getId())
                .status(order.getStatus().name())
                .createdBy(order.getCreatedBy())
                .createdBy(order.getCreatedBy())
                .lastModifiedBy(order.getLastModifiedBy())
                .lastModifiedAt(order.getLastModifiedAt())
                .orderItems(fromItems(order.getOrderItems()))
                .build();
    }

    public List<OrderResponse> fromOrders(List<Order> orders){
        return orders.stream().map(OrderConverter::from).toList();
    }

    public OrderItemResponse from(OrderItem orderItem){
        return OrderItemResponse.builder()
                .id(orderItem.getId())
                .productId(orderItem.getProduct().getId())
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .createdAt(orderItem.getCreatedAt())
                .createdBy(orderItem.getCreatedBy())
                .build();
    }

    public List<OrderItemResponse> fromItems(List<OrderItem> orderItems){
        return orderItems.stream().map(OrderConverter::from).toList();
    }

    public Order convertToEntity(OrderUpdateRequest updateRequest) {
        return Order.builder()
                .status(updateRequest.getStatus())
                .build();
    }

    public OrderItem convertToEntity(OrderItemRequest item) {
        return OrderItem.builder()
                .quantity(item.getQuantity())
                .build();
    }
}
