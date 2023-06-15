package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.model.entity.Order;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.repository.OrderRepository;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import com.example.educationalmaterialsshop.common.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public Order create(Integer productId, Order order) {
        Product product = getProduct(productId);
        product.setCurrentQuantity(product.getCurrentQuantity()- order.getQuantity());
        order.setDate(Instant.now());
        Product save = productRepository.save(product);
        order.setProduct(save);
        return orderRepository.save(order);
    }

    public Order get(int id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "Order with id - '%s' cannot be found", id
                ))
        );
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void delete(int id) {
        Order order = get(id);
        orderRepository.delete(order);
    }


    private Product getProduct(int id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "Product with id - '%s' cannot be found", id
                ))
        );
    }

}
