package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.model.dto.request.ProductRequest;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements BaseService<ProductRequest,Integer> {
    private final ProductRepository productRepository;

    @Override
    public Integer create(ProductRequest productRequest) {
        return null;
    }

    @Override
    public Integer get(Integer id) {
        return null;
    }

    @Override
    public Integer getAll() {
        return null;
    }

    @Override
    public Integer update(ProductRequest productRequest, Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }
}
