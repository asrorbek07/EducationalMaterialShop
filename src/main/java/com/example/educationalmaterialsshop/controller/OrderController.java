package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.OrderConverter;
import com.example.educationalmaterialsshop.model.entity.Order;
import com.example.educationalmaterialsshop.model.payload.request.OrderCreateRequest;
import com.example.educationalmaterialsshop.model.payload.response.OrderResponse;
import com.example.educationalmaterialsshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            @RequestBody OrderCreateRequest orderCreateRequest
    ){
        Order order = OrderConverter.convertToEntity(orderCreateRequest);
        return OrderConverter.from(orderService.create(orderCreateRequest.getProductId(),order));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse get(
            @PathVariable int id
    ){
        Order order = orderService.get(id);
        return OrderConverter.from(order);
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAll(){
        List<Order> orders = orderService.getAll();
        return OrderConverter.from(orders);
    }




    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable int id
    ){
        orderService.delete(id);
    }

}
