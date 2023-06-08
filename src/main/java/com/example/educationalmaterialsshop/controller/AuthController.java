package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.UserConverter;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.model.payload.request.UserLoginRequest;
import com.example.educationalmaterialsshop.model.payload.request.UserRegisterRequest;
import com.example.educationalmaterialsshop.model.payload.response.JwtToken;
import com.example.educationalmaterialsshop.model.payload.response.UserResponse;
import com.example.educationalmaterialsshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {
    private final UserService userService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(
            @RequestBody UserRegisterRequest registerRequest
    ) {
        User newUser = UserConverter.convertToEntity(registerRequest);
        User user = userService.create(newUser);
        return UserConverter.from(user);
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public JwtToken login(
            @RequestBody UserLoginRequest loginRequest
    ) {
        User user = UserConverter.convertToEntity(loginRequest);
        return userService.login(user);
    }
}
