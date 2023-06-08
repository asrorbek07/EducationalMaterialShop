package com.example.educationalmaterialsshop.controller.converter;

import com.example.educationalmaterialsshop.model.entity.Permission;
import com.example.educationalmaterialsshop.model.entity.Role;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.model.payload.request.BaseUserRequest;
import com.example.educationalmaterialsshop.model.payload.request.UserLoginRequest;
import com.example.educationalmaterialsshop.model.payload.response.UserResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserConverter {
    public User convertToEntity(BaseUserRequest request){
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .postalCode(request.getPostalCode())
                .build();
    }

    public User convertToEntity(UserLoginRequest request){
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
    }

    public UserResponse from(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .roleEntities(getRoles(user.getRoleEntities()))
                .permissionEntities(getPermissions(user.getPermissionEntities()))
                .phoneNumber(user.getPhoneNumber())
                .address(user.getAddress())
                .postalCode(user.getPostalCode())
                .build();
    }

    public List<UserResponse> from(List<User> users){
        return users.stream().map(UserConverter::from).toList();
    }

    private List<String> getPermissions(List<Permission> permissionEntities) {
        return permissionEntities.stream().map(Permission::getName).toList();
    }

    private List<String> getRoles(List<Role> roleEntities) {
        return roleEntities.stream().map(Role::getName).toList();
    }
}
