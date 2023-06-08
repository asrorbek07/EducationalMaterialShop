package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.model.entity.Category;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.payload.request.ProductCreateRequest;
import com.example.educationalmaterialsshop.model.payload.request.ProductUpdateRequest;
import com.example.educationalmaterialsshop.repository.CategoryRepository;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final Validator validator;

    public Product create(int categoryId, Product product) {
        validator.validateProduct(null,product);
        Category category = getCategory(categoryId);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product get(int id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new RecordNotFountException(String.format(
                        "Product with id - '%s' cannot be found",id
                ))
        );
    }

    public List<Product> getAll(int id) {
        return productRepository.findAllByCategory_Id(id).orElseThrow(
                ()-> new RecordNotFountException(String.format(
                "Category with id - '%s' cannot be found",id)));
    }

    public Product update(int id, int categoryId,Product updatingProduct) {
        Product product = get(id);
        validator.validateProduct(id,updatingProduct);
        updatingProduct.setId(id);
        if(categoryId!=product.getCategory().getId()) {
            Category category = getCategory(categoryId);
            updatingProduct.setCategory(category);
        }
        return productRepository.save(updatingProduct);
    }

    public void delete(int id) {
        Product product = get(id);
        productRepository.delete(product);
    }

    private Category getCategory(int id){
        return categoryRepository.findById(id).orElseThrow(
                ()-> new RecordNotFountException(String.format(
                        "Category cannot be found with id - '%s'",id))
        );
    }
}
