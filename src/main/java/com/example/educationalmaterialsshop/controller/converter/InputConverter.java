package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Input;
import com.example.educationalmaterialsshop.model.payload.request.BaseInputRequest;
import com.example.educationalmaterialsshop.model.payload.request.InputCreateRequest;
import com.example.educationalmaterialsshop.model.payload.response.InputResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class InputConverter {
    public InputResponse from(Input input){
        return InputResponse.builder()
                .id(input.getId())
                .quantity(input.getQuantity())
                .price(input.getPrice())
                .totalPrice(input.getTotalPrice())
                .date(input.getDate())
                .productResponse(ProductConverter.from(input.getProduct()))
                .supplierResponse(SupplierConverter.from(input.getSupplier()))
                .build();
    }
    public List<InputResponse> from(List<Input> inputs){
        return inputs.stream().map(InputConverter::from).toList();
    }

    public Input convertToEntity(BaseInputRequest inputRequest){
        return Input.builder()
                .quantity(inputRequest.getQuantity())
                .price(inputRequest.getPrice())
                .totalPrice(inputRequest.getPrice()* inputRequest.getQuantity())
                .build();
    }
}
