package com.example.educationalmaterialsshop.common.validation;

import com.example.educationalmaterialsshop.common.exception.AlreadyExistsException;
import com.example.educationalmaterialsshop.model.entity.Product;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.repository.ProductRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class Validator {
    private final UserRepository userRepository;
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

    public void
    validateProduct(Product product) {
        String name = product.getName();
        if( productRepository.existsByName(name))
            throwIfExists("name",name);
//        double purchasePrice = product.getPurchasePrice();
//        double sellingPrice = product.getSellingPrice();
//        if(purchasePrice<0||sellingPrice<0)
//            throwIfInvalid("price",purchasePrice);
//        int quantity = product.getFirstQuantity();
//        if(quantity<0)
//            throwIfInvalid("quantity",quantity);

    }

    private void throwIfInvalid(String property, Object value) {
        throw new IllegalArgumentException(String.format(
                "%s property cannot get '%s' value",property,value));
    }

    private void throwIfExists(String property, Object value) {
        throw new AlreadyExistsException(String.format(
                "Record with %s - '%s' already exists",property,value));
    }

}
