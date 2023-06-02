package com.example.educationalmaterialsshop.controller;


import com.example.educationalmaterialsshop.model.dto.request.LoginRequest;
import com.example.educationalmaterialsshop.model.dto.request.UserRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.model.dto.response.TokenDTO;
import com.example.educationalmaterialsshop.model.dto.response.UserResponse;
import com.example.educationalmaterialsshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
private final UserService userService;
@PostMapping("register")
    public ApiResponse<UserResponse> register(
        @RequestBody UserRequest userRequest
        ){
    return userService.create(userRequest);
}
@GetMapping("login")
    public ApiResponse<TokenDTO> login(
        @RequestBody LoginRequest loginRequest
        ){
    return userService.login(loginRequest);
}
}
