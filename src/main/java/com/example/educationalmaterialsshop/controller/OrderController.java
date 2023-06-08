package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.OrderConverter;
import com.example.educationalmaterialsshop.model.entity.Order;
import com.example.educationalmaterialsshop.model.payload.request.OrderCreateRequest;
import com.example.educationalmaterialsshop.model.payload.request.OrderUpdateRequest;
import com.example.educationalmaterialsshop.model.payload.response.OrderResponse;
import com.example.educationalmaterialsshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(
            @RequestBody OrderCreateRequest createRequest
    ){
        Order order = orderService.create(createRequest);
        return OrderConverter.from(order);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getAll(
            @PathVariable int id
    ){
        Order order = orderService.get(id);
        return OrderConverter.from(order);
    }

    @GetMapping("all/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> get(
            @PathVariable int id
    ){
        List<Order> orders = orderService.getAll(id);
        return OrderConverter.fromOrders(orders);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN') and hasAuthority('UPDATE')")
    public OrderResponse update(
            @PathVariable int id,
            @RequestBody OrderUpdateRequest updateRequest
    ){
        Order updatedOrder = OrderConverter.convertToEntity(updateRequest);
        Order order = orderService.update(id,updateRequest);
        return OrderConverter.from(order);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable int id
    ){
        orderService.delete(id);
    }

}
