package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.common.ResponseMessage;
import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.model.entity.Category;
import com.example.educationalmaterialsshop.repository.CategoryRepository;
import com.example.educationalmaterialsshop.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService{
    private final CategoryRepository categoryRepository;
    private final Validator validator;

    public Category create(Category category) {
        validator.validateCategory(category);
        return categoryRepository.save(category);
    }

    public Category get(int id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new RecordNotFountException(String.format(
                        "Category cannot be found with id - '%s'",id
                ))
        );
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category update(int id,Category updatingCategory) {
        Category category = get(id);
        validator.validateCategory(updatingCategory,id);
        category.setName(updatingCategory.getName());
        return categoryRepository.save(category);
    }

    public void delete(int id) {
        Category category = get(id);
        categoryRepository.delete(category);
    }
}
