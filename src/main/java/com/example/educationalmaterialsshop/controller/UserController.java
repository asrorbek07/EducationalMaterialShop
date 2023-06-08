package com.example.educationalmaterialsshop.controller;

import com.example.educationalmaterialsshop.controller.converter.UserConverter;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.model.payload.request.UserUpdateRequest;
import com.example.educationalmaterialsshop.model.payload.response.UserResponse;
import com.example.educationalmaterialsshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@EnableMethodSecurity
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
    public UserResponse get(
            @PathVariable int id
    ) {
        User user = userService.get(id);
        return UserConverter.from(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
    public List<UserResponse> getAll(
    ) {
        List<User> users = userService.getAll();
        return UserConverter.from(users);
    }

    @GetMapping("get-me")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse get(
            Principal principal
    ) {
        String username = principal.getName();
        User user = userService.get(username);
        return UserConverter.from(user);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse update(
            @PathVariable int id,
            @RequestBody UserUpdateRequest updateRequest
    ) {
        User updatingUser = UserConverter.convertToEntity(updateRequest);
        User updatedUser = userService.update(updatingUser, id);
        return UserConverter.from(updatedUser);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable int id
    ){
        userService.delete(id);
    }
}
