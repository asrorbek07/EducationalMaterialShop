package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Order;
import com.example.educationalmaterialsshop.model.payload.request.BaseOrderRequest;
import com.example.educationalmaterialsshop.model.payload.response.OrderResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderConverter {

    public OrderResponse from(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .profit(order.getProfit())
                .productResponse(ProductConverter.from(order.getProduct()))
                .quantity(order.getQuantity())
                .purchasePrice(order.getPurchasePrice())
                .sellingPrice(order.getSellingPrice())
                .date(order.getDate())
                .build();
    }

    public List<OrderResponse> from(List<Order> orders){
        return orders.stream().map(OrderConverter::from).toList();
    }

    public Order convertToEntity(BaseOrderRequest orderRequest){
        return Order.builder()
                .quantity(orderRequest.getQuantity())
                .purchasePrice(orderRequest.getPurchasePrice())
                .sellingPrice(orderRequest.getSellingPrice())
                .profit(orderRequest.getQuantity()*( orderRequest.getSellingPrice()- orderRequest.getPurchasePrice()))
                .build();
    }

}
