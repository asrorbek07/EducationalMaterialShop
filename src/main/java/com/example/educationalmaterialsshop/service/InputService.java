package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.model.entity.Input;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.entity.Supplier;
import com.example.educationalmaterialsshop.repository.InputRepository;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InputService {
    private final ProductRepository productRepository;
    private final InputRepository inputRepository;
    private final SupplierRepository supplierRepository;
    public Input create(Integer supplierId, Integer productId, Input input){
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "Product with id - '%s' cannot be found", productId
                ))
        );
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow(() ->
                new RecordNotFountException(String.format(
                        "Supplier with id - '%s' cannot be found", supplierId
                )));
        if (product.getAllQuantity()==0){
            product.setAllQuantity(input.getQuantity());
            product.setCurrentQuantity(input.getQuantity());
            product.setPurchasePrice(input.getPrice());
            product.setSellingPrice(product.getPurchasePrice()*1.2);
        } else {
            int quantity = product.getCurrentQuantity() + input.getQuantity();
            double purchasePrice = (product.getPurchasePrice() * product.getCurrentQuantity() + input.getPrice() * input.getQuantity()) /
                    (double) quantity;
            product.setPurchasePrice(purchasePrice);
            product.setSellingPrice(purchasePrice*1.2);
            product.setCurrentQuantity(quantity);
            product.setAllQuantity(product.getAllQuantity()+ input.getQuantity());
        }
        product = productRepository.save(product);
        input.setProduct(product);
        input.setSupplier(supplier);
        input.setDate(Instant.now());
        return inputRepository.save(input);

    }

    public List<Input> getAll() {
        return inputRepository.findAll();
    }
}
