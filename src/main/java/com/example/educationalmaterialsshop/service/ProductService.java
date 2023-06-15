package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.common.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final Validator validator;

    public Product create(Product product) {
        validator.validateProduct(product);
        product.setDate(Instant.now());
        return productRepository.save(product);
    }

    public Product get(int id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new RecordNotFountException(String.format(
                        "Product with id - '%s' cannot be found",id
                ))
        );
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product update(int id, Product updatingProduct) {
        Product product = get(id);
        validator.validateProduct(updatingProduct);
        if (product!=null){
            product.setName(updatingProduct.getName());
            product.setDescription(updatingProduct.getDescription());
            product=productRepository.save(product);
        }
        return product;
    }

    public void delete(int id) {
        Product product = get(id);
        productRepository.delete(product);
    }

}
