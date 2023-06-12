package com.example.educationalmaterialsshop.validation;

import com.example.educationalmaterialsshop.common.exception.AlreadyExistsException;
import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.model.entity.Category;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.model.payload.request.OrderItemRequest;
import com.example.educationalmaterialsshop.repository.CategoryRepository;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class Validator {
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public void validateUser(User user){
        String username = user.getUsername();
        boolean exists = userRepository.existsByUsername(username);
        if(exists)
            throwIfExists("username",username);
        String phoneNumber = user.getPhoneNumber();
        exists = userRepository.existsByPhoneNumber(phoneNumber);
        if(exists)
            throwIfExists("phone number",phoneNumber);
    }

    public void validateUser(User user, int id) {
        String username = user.getUsername();
        boolean exists = userRepository.existsByUsernameAndIdNot(username, id);
        if(exists)
            throwIfExists("username", username);
        String phoneNumber = user.getPhoneNumber();
        exists = userRepository.existsByPhoneNumberAndIdNot(phoneNumber,id);
        if(exists)
            throwIfExists("phone number",phoneNumber);
    }

    public void validateCategory(Category category) {
        String name = category.getName();
        boolean exists = categoryRepository.existsByName(name);
        if(exists)
            throwIfExists("name",name);
    }

    public void validateCategory(Category category, int id) {
        String name = category.getName();
        boolean exists = categoryRepository.existsByNameAndIdNot(name, id);
        if(exists)
            throwIfExists("name",name);
    }

    public void validateProduct(Integer id,Product product) {
        String name = product.getName();
        boolean exists;
        if(Objects.isNull(id))
            exists = productRepository.existsByName(name);
        else
            exists = productRepository.existsByNameAndIdNot(name,id);
        if(exists)
            throwIfExists("name",name);
        double price = product.getPrice();
        if(price<=0)
            throwIfInvalid("price",price);
        int quantity = product.getQuantity();
        if(quantity<=0)
            throwIfInvalid("quantity",quantity);
        int ISBN = product.getIsbn();
        exists = productRepository.existsByIsbn(ISBN);
        if(exists)
            throwIfExists("ISBN",ISBN);

    }

    private void throwIfInvalid(String property, Object value) {
        throw new IllegalArgumentException(String.format(
                "%s property cannot get '%s' value",property,value));
    }

    private void throwIfExists(String property, Object value) {
        throw new AlreadyExistsException(String.format(
                "Record with %s - '%s' already exists",property,value));
    }

    public void validateItem(OrderItemRequest item) {
        int id = item.getProductId();
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(String.format(
                        "Record with id -'%s' cannot be found", id
                ))
        );
        int quantity = item.getQuantity();
        if(quantity> product.getQuantity())
            throwIfInvalid("quantity",quantity);
    }
}
