package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.model.dto.request.UserRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.model.dto.response.UserResponse;
import com.example.educationalmaterialsshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;
    @GetMapping("get/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
    public ApiResponse<UserResponse> get(
            @PathVariable Integer id
    ){
        return userService.get(id);
    }
    @GetMapping("getAll")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
    public ApiResponse<UserResponse> getAll(
    ){
        return userService.getAll();
    }
    @GetMapping("getMe")
    public ApiResponse<UserResponse> getMe(
            Principal principal
    ){
        return userService.getMe(principal.getName());
    }
    @PutMapping("update/{id}")
    public ApiResponse<UserResponse> update(
            @RequestBody UserRequest userRequest,
            @PathVariable Integer id
            ){
        return userService.update(userRequest, id);
    }
}
