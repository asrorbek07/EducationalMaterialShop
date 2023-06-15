package com.example.educationalmaterialsshop.model.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseProductRequest {
    @NotBlank
    String name;
    @NotBlank
    String description;
}
