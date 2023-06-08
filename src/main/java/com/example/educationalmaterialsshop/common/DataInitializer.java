package com.example.educationalmaterialsshop.common;

import com.example.educationalmaterialsshop.model.entity.Permission;
import com.example.educationalmaterialsshop.model.entity.Role;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.repository.PermissionRepository;
import com.example.educationalmaterialsshop.repository.RoleRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private  final UserRepository userRepository;
    private  final RoleRepository roleRepository;
    private  final PermissionRepository permissionRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Permission> all = permissionRepository.findAll();
        if (all.isEmpty()){
            permissionRepository.saveAll(List.of(
                    new Permission("CREATE"),
                    new Permission("READ"),
                    new Permission("UPDATE"),
                    new Permission("DELETE")
                    ));
        }
        if (roleRepository.findAll().isEmpty()){
            roleRepository.saveAll(List.of(
                    new Role("SUPER_ADMIN"),
                    new Role("ADMIN"),
                    new Role("USER")
            ));
        }
        if (userRepository.findByUsername("superAdmin").isEmpty()){
            User user = User.builder()
                    .firstName("Asrorbek")
                    .lastName("Obidjonov")
                    .username("superAdmin")
                    .password("superAdmin")
                    .permissionEntities(permissionRepository.findByNameIn(List.of("CREATE", "READ", "UPDATE", "DELETE")))
                    .roleEntities(List.of(roleRepository.findByName("SUPER_ADMIN")))
                    .address("Fergana")
                    .postalCode("123456")
                    .phoneNumber("+998949209920")
                    .build();
            userRepository.save(user);
        }
    }
}
