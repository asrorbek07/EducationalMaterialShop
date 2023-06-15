package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.ProductConverter;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.payload.request.ProductCreateRequest;
import com.example.educationalmaterialsshop.model.payload.request.ProductUpdateRequest;
import com.example.educationalmaterialsshop.model.payload.response.ProductResponse;
import com.example.educationalmaterialsshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product/")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(
            @RequestBody ProductCreateRequest createRequest
    ){
        Product product = ProductConverter.convertToEntity(createRequest);

        product = productService.create(product);
        return ProductConverter.from(product);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse get(
            @PathVariable int id
    ){
        Product product = productService.get(id);
        return ProductConverter.from(product);
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAll(
    ){
        List<Product> products = productService.getAll();
        return ProductConverter.from(products);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN') and hasAuthority('UPDATE')")
    public ProductResponse update(
            @PathVariable int id,
            @RequestBody ProductUpdateRequest updateRequest
    ){
        Product product = ProductConverter.convertToEntity(updateRequest);
        product = productService.update(id,product);
        return ProductConverter.from(product);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN') and hasAuthority('DELETE')")
    public void delete(
            @PathVariable int id
    ){
        productService.delete(id);
    }

}
