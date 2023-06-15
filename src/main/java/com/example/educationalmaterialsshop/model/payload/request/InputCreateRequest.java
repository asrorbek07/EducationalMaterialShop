package com.example.educationalmaterialsshop.model.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputCreateRequest extends BaseInputRequest{
    Integer supplierId;
    Integer productId;
}
