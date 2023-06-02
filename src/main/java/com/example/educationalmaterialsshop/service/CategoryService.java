package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.model.dto.request.CategoryRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements BaseService<CategoryRequest, ApiResponse>{
    private final CategoryRepository categoryRepository;
    @Override
    public ApiResponse create(CategoryRequest categoryRequest) {
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
    public ApiResponse update(CategoryRequest categoryRequest, Integer id) {
        return null;
    }

    @Override
    public ApiResponse delete(Integer id) {
        return null;
    }
}
