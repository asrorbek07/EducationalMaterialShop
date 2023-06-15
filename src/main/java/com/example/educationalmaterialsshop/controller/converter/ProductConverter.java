package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.payload.request.BaseProductRequest;
import com.example.educationalmaterialsshop.model.payload.response.ProductResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductConverter {

    public ProductResponse from(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .purchasePrice(product.getPurchasePrice())
                .sellingPrice(product.getSellingPrice())
                .description(product.getDescription())
                .allQuantity(product.getAllQuantity())
                .currentQuantity(product.getCurrentQuantity())
                .date(product.getDate())
                .build();
    }

    public List<ProductResponse> from(List<Product> products) {
        return products.stream().map(ProductConverter::from).toList();
    }

    public Product convertToEntity(BaseProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }
}
