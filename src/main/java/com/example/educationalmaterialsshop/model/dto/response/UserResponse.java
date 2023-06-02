package com.example.educationalmaterialsshop.model.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class UserResponse {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<String> roleEntities;
    private List<String> permissionEntities;
    private String phoneNumber;
    private String address;
    private String postalCode;
}
