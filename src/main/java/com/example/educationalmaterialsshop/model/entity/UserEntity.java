package com.example.educationalmaterialsshop.model.entity;

import com.example.educationalmaterialsshop.model.dto.request.UserRequest;
import com.example.educationalmaterialsshop.model.dto.response.UserResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> roleEntities;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<PermissionEntity> permissionEntities;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String postalCode;

    public UserEntity(UserRequest userRequest) {
        this.username = userRequest.getUsername();
        this.password = userRequest.getPassword();
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.phoneNumber = userRequest.getPhoneNumber();
        this.address = userRequest.getAddress();
        this.postalCode = userRequest.getPostalCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list =new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities) {
            list.add(new SimpleGrantedAuthority("Role_"+roleEntity.getName()));
        }
        for (PermissionEntity permissionEntity : permissionEntities) {
            list.add(new SimpleGrantedAuthority(permissionEntity.getName()));
        }
        return list;
    }
    public UserResponse getUserResponseDto(){
        return UserResponse.builder()
                .id(this.id)
                .username(this.username)
                .password(this.password)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .roleEntities(this.getRolesList())
                .permissionEntities(this.getPermissionsList())
                .phoneNumber(this.phoneNumber)
                .postalCode(this.postalCode)
                .address(this.address)
                .build();
    }
    public List<String> getRolesList(){
        return roleEntities.stream().map(RoleEntity::getName).toList();
    }
    public List<String> getPermissionsList(){
        return permissionEntities.stream().map(PermissionEntity::getName).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
