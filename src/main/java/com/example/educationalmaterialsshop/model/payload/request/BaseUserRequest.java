package com.example.educationalmaterialsshop.model.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseUserRequest {
    @NotBlank
    String username;
    @NotBlank
    String password;
    @NotBlank
    String firstName;
    String lastName;
    @NotBlank
    String phoneNumber;
    @NotBlank
    String address;
    @NotBlank
    String postalCode;
}
