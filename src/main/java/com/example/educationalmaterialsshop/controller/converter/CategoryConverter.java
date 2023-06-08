package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Category;
import com.example.educationalmaterialsshop.model.payload.request.BaseCategoryRequest;
import com.example.educationalmaterialsshop.model.payload.request.CategoryCreateRequest;
import com.example.educationalmaterialsshop.model.payload.response.CategoryResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CategoryConverter {

    public Category convertToEntity(BaseCategoryRequest request) {
        return Category.builder()
                .name(request.getName())
                .build();
    }

    public CategoryResponse from(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .createdBy(category.getCreatedBy())
                .createdAt(category.getCreatedAt())
                .lastModifiedBy(category.getLastModifiedBy())
                .lastModifiedAt(category.getLastModifiedAt())
                .build();
    }

    public static List<CategoryResponse> from(List<Category> categories) {
        return categories.stream().map(CategoryConverter::from).toList();
    }
}
