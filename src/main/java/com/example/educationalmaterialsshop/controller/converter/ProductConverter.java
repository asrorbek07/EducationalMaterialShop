package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.payload.request.BaseProductRequest;
import com.example.educationalmaterialsshop.model.payload.request.ProductCreateRequest;
import com.example.educationalmaterialsshop.model.payload.response.ProductResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductConverter {

    public ProductResponse from(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .ISBN(product.getISBN())
                .build();
    }

    public List<ProductResponse> from(List<Product> products) {
        return products.stream().map(ProductConverter::from).toList();
    }

    public Product convertToEntity(BaseProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .ISBN(request.getISBN())
                .build();
    }
}
