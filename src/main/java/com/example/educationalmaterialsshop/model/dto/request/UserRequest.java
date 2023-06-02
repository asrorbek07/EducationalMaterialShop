package com.example.educationalmaterialsshop.model.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
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

