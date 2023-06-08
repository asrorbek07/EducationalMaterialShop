package com.example.educationalmaterialsshop.model.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseCategoryRequest {
    @NotBlank
    String name;
}
