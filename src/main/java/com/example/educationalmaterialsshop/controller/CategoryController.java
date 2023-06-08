package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.CategoryConverter;
import com.example.educationalmaterialsshop.model.entity.Category;
import com.example.educationalmaterialsshop.model.payload.request.CategoryCreateRequest;
import com.example.educationalmaterialsshop.model.payload.request.CategoryUpdateRequest;
import com.example.educationalmaterialsshop.model.payload.response.CategoryResponse;
import com.example.educationalmaterialsshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category/")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN') and hasAuthority('CREATE')")
    public CategoryResponse create(
            @RequestBody CategoryCreateRequest createRequest
    ){
        Category newCategory = CategoryConverter.convertToEntity(createRequest);
        Category category = categoryService.create(newCategory);
        return CategoryConverter.from(category);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse get(
            @PathVariable int id
    ){
        Category category = categoryService.get(id);
        return CategoryConverter.from(category);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> get(){
        List<Category> categories = categoryService.getAll();
        return CategoryConverter.from(categories);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN') and hasAuthority('UPDATE')")
    public CategoryResponse update(
            @PathVariable int id,
            @RequestBody CategoryUpdateRequest updateRequest
    ){
        Category updatedCategory = CategoryConverter.convertToEntity(updateRequest);
        Category category = categoryService.update(id,updatedCategory);
        return CategoryConverter.from(category);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN') and hasAuthority('DELETE')")
    public void delete(
            @PathVariable int id
    ){
        categoryService.delete(id);
    }

}
