package com.example.educationalmaterialsshop.model.entity;

import com.example.educationalmaterialsshop.model.payload.request.UserRegisterRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String firstName;
    String lastName;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roleEntities;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Permission> permissionEntities;
    @Column(nullable = false, unique = true)
    String phoneNumber;
    @Column(nullable = false)
    String address;
    @Column(nullable = false)
    String postalCode;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    List<Order> orders;

    public User(UserRegisterRequest userRegisterRequest) {
        this.username = userRegisterRequest.getUsername();
        this.password = userRegisterRequest.getPassword();
        this.firstName = userRegisterRequest.getFirstName();
        this.lastName = userRegisterRequest.getLastName();
        this.phoneNumber = userRegisterRequest.getPhoneNumber();
        this.address = userRegisterRequest.getAddress();
        this.postalCode = userRegisterRequest.getPostalCode();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list =new ArrayList<>();
        for (Role role : roleEntities) {
            list.add(new SimpleGrantedAuthority("Role_"+ role.getName()));
        }
        for (Permission permission : permissionEntities) {
            list.add(new SimpleGrantedAuthority(permission.getName()));
        }
        return list;
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
