package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.model.dto.request.CategoryRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.service.BaseService;
import com.example.educationalmaterialsshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category/")
public class CategoryController implements BaseService<CategoryRequest, ApiResponse> {
    private final CategoryService categoryService;

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
