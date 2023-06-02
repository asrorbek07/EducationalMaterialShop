package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.model.dto.request.ProductRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.service.BaseService;
import com.example.educationalmaterialsshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product/")
public class ProductController implements BaseService<ProductRequest, ApiResponse> {
    private final ProductService productService;

    @Override
    public ApiResponse create(ProductRequest productRequest) {
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
    public ApiResponse update(ProductRequest productRequest, Integer id) {
        return null;
    }

    @Override
    public ApiResponse delete(Integer id) {
        return null;
    }
}
