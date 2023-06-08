package com.example.educationalmaterialsshop.service;

import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.controller.converter.OrderConverter;
import com.example.educationalmaterialsshop.model.entity.Order;
import com.example.educationalmaterialsshop.model.entity.OrderItem;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.model.enums.OrderStatus;
import com.example.educationalmaterialsshop.model.payload.request.OrderCreateRequest;
import com.example.educationalmaterialsshop.model.payload.request.OrderItemRequest;
import com.example.educationalmaterialsshop.model.payload.request.OrderUpdateRequest;
import com.example.educationalmaterialsshop.repository.OrderItemRepository;
import com.example.educationalmaterialsshop.repository.OrderRepository;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import com.example.educationalmaterialsshop.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository itemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public Order create(OrderCreateRequest orderRequest) {
        int customerId = orderRequest.getCustomerId();
        User user = getUser(customerId);
        Order newOrder = Order.builder()
                .customer(user)
                .build();
        Order order = orderRepository.save(newOrder);
        List<OrderItemRequest> orderItems = orderRequest.getOrderItems();
        orderItems.forEach(item ->saveItem(item, order));
        return order;
    }

    public Order get(int id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "Order with id - '%s' cannot be found", id
                ))
        );
    }

    public List<Order> getAll(int id) {
        return orderRepository.findAllByCustomerId(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "User with id - '%s' cannot be found", id
                ))
        );
    }

    public Order update(int id, OrderUpdateRequest updateRequest) {
        Order order = get(id);
        OrderStatus status = updateRequest.getStatus();
        order.setStatus(status);
        order = orderRepository.save(order);
        if (status.equals(OrderStatus.DELIVERED))
            completeOrder(order);
        return order;
    }

    public void delete(int id) {
        Order order = get(id);
        orderRepository.delete(order);
    }

    private void completeOrder(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        orderItems.forEach(orderItem -> {
                    Product product = orderItem.getProduct();
                    product.setQuantity(product.getQuantity() - orderItem.getQuantity());
                    productRepository.save(product);
                }
        );
    }


    private Product getProduct(int id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "Product with id - '%s' cannot be found", id
                ))
        );
    }

    private void saveItem(OrderItemRequest item, Order order) {
        validator.validateItem(item);
        Product product = getProduct(item.getProductId());
        OrderItem orderItem = OrderConverter.convertToEntity(item);
        orderItem.setProduct(product);
        double price = orderItem.getQuantity() * product.getPrice();
        orderItem.setPrice(price);
        orderItem.setOrder(order);
        itemRepository.save(orderItem);
    }

    private User getUser(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "User with id - '%s' cannot be found", id
                ))
        );
    }
}
