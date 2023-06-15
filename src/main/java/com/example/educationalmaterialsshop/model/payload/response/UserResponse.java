package com.example.educationalmaterialsshop.model.payload.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Integer id;
    String username;
    String password;
    String firstName;
    String lastName;
    List<String> roleEntities;
    List<String> permissionEntities;
    String phoneNumber;
    String address;
    Instant date;
}
