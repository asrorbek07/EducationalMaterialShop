package com.example.educationalmaterialsshop.service;


import com.example.educationalmaterialsshop.common.ResponseMessage;
import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.common.jwt.JwtUtils;
import com.example.educationalmaterialsshop.model.payload.response.JwtToken;
import com.example.educationalmaterialsshop.model.entity.Permission;
import com.example.educationalmaterialsshop.model.entity.Role;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.repository.PermissionRepository;
import com.example.educationalmaterialsshop.repository.RoleRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import com.example.educationalmaterialsshop.common.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public User create(User newUser) {
        validator.validateUser(newUser);
        newUser.setPermissionEntities(defaultPermissions());
        newUser.setRoleEntities(defaultRoles());
        return userRepository.save(newUser);
    }

    public JwtToken login(User login) {
        User user = userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword()).orElseThrow(
                () -> new RecordNotFountException("Invalid Password or Username"));
        String accessToken = JwtUtils.generateAccessToken(user);
        String refreshToken = JwtUtils.generateRefreshToken(user);
        return JwtToken.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(User updatingUser, int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RecordNotFountException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
        validator.validateUser(updatingUser, id);
        updatingUser.setId(id);
        updatingUser.setRoleEntities(user.getRoleEntities());
        updatingUser.setPermissionEntities(user.getPermissionEntities());
        return userRepository.save(updatingUser);
    }

    public void delete(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(ResponseMessage.SUCCESS.getMessage()));
        userRepository.delete(user);
    }

    public User get(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new RecordNotFountException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
    }

    private List<Role> defaultRoles() {
        return List.of(roleRepository.findByName("USER"));
    }

    private List<Permission> defaultPermissions() {
        return permissionRepository.findByNameIn(List.of("READ"));
    }
}
