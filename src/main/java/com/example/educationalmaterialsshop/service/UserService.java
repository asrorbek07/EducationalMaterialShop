package com.example.educationalmaterialsshop.service;


import com.example.educationalmaterialsshop.common.ResponseMessage;
import com.example.educationalmaterialsshop.common.exception.PermissionNotFoundException;
import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.common.exception.RoleNotFoundException;
import com.example.educationalmaterialsshop.jwt.JwtUtils;
import com.example.educationalmaterialsshop.model.dto.request.LoginRequest;
import com.example.educationalmaterialsshop.model.dto.request.UserRequest;
import com.example.educationalmaterialsshop.model.dto.response.ApiResponse;
import com.example.educationalmaterialsshop.model.dto.response.TokenDTO;
import com.example.educationalmaterialsshop.model.dto.response.UserResponse;
import com.example.educationalmaterialsshop.model.entity.PermissionEntity;
import com.example.educationalmaterialsshop.model.entity.RoleEntity;
import com.example.educationalmaterialsshop.model.entity.UserEntity;
import com.example.educationalmaterialsshop.repository.PermissionRepository;
import com.example.educationalmaterialsshop.repository.RoleRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserRequest, ApiResponse>{
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse create(UserRequest userRequest) {
        List<RoleEntity> roleEntities = checkRoles(userRequest.getRoleEntities());
        List<PermissionEntity> permissionEntities = checkPermissions(userRequest.getPermissionEntities());
        UserEntity userEntity = new UserEntity(userRequest);
        userEntity.setPermissionEntities(permissionEntities);
        userEntity.setRoleEntities(roleEntities);
        userRepository.save(userEntity);
        return new ApiResponse(userEntity.getUserResponseDto(), ResponseMessage.SUCCESS.getMessage());
    }

    public ApiResponse<TokenDTO> login(LoginRequest loginRequest){
        UserEntity userEntity = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()).orElseThrow(() -> new RecordNotFountException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
        String accessToken = JwtUtils.generateAccessToken(userEntity);
        String refreshToken = JwtUtils.generateRefreshToken(userEntity);
        TokenDTO token = TokenDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        return new ApiResponse<>(token,ResponseMessage.SUCCESS.getMessage());
    }

    private List<RoleEntity> checkRoles(List<String> roles) {
        if (roles==null) return List.of(roleRepository.findByName("USER").get());
        return roles.stream().map(s -> roleRepository.findByName(s).orElseThrow(() ->
                new RoleNotFoundException(ResponseMessage.ERROR_ROLE_NOT_FOUND.getMessage()))).toList();
    }
    private List<PermissionEntity> checkPermissions(List<String> permissions){
        if (permissions==null) return permissionRepository.findByNameIn(List.of("READ")).get();
        return permissions.stream().map(p -> permissionRepository.findByName(p).orElseThrow(() ->
                new PermissionNotFoundException(ResponseMessage.ERROR_PERMISSION_NOT_FOUND.getMessage()))).toList();
    }

    @Override
    public ApiResponse<UserResponse> get(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RecordNotFountException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
        return new ApiResponse<>(userEntity.getUserResponseDto(), ResponseMessage.SUCCESS.getMessage());
    }

    @Override
    public ApiResponse getAll() {
        List<UserResponse> userResponses = userRepository.findAll().stream().map(UserEntity::getUserResponseDto).toList();
        return new ApiResponse<>(userResponses,ResponseMessage.SUCCESS.getMessage());
    }

    @Override
    public ApiResponse update(UserRequest userRequest, Integer id) {
        userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
        UserEntity userEntity = new UserEntity(userRequest);
        userEntity.setId(id);
        userEntity.setRoleEntities(checkRoles(userRequest.getRoleEntities()));
        userEntity.setPermissionEntities(checkPermissions(userRequest.getPermissionEntities()));
        userEntity = userRepository.save(userEntity);
        return new ApiResponse<>(userEntity.getUserResponseDto(),ResponseMessage.SUCCESS.getMessage());
    }

    @Override
    public ApiResponse delete(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(ResponseMessage.SUCCESS.getMessage()));
        userRepository.delete(userEntity);
        return new ApiResponse<>(null,ResponseMessage.SUCCESS.getMessage());
    }

    public ApiResponse<UserResponse> getMe(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new RecordNotFountException(ResponseMessage.ERROR_USER_NOT_FOUND.getMessage()));
        return new ApiResponse<>(userEntity.getUserResponseDto(), ResponseMessage.SUCCESS.getMessage());
    }
}
