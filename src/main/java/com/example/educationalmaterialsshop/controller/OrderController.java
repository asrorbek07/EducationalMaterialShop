package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.model.dto.request.OrderRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.service.BaseService;
import com.example.educationalmaterialsshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order/")
public class OrderController implements BaseService<OrderRequest, ApiResponse> {
    private final OrderService orderService;

    @Override
    public ApiResponse create(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public ApiResponse get(Integer id) {
        return null;
    }

    @Override
    public ApiResponse getAll() {
        return null;
    }

    @Override
    public ApiResponse update(OrderRequest orderRequest, Integer id) {
        return null;
    }

    @Override
    public ApiResponse delete(Integer id) {
        return null;
    }
}
