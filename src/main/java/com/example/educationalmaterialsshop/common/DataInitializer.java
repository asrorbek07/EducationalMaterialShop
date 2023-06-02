package com.example.educationalmaterialsshop.common;


import com.example.educationalmaterialsshop.model.entity.PermissionEntity;
import com.example.educationalmaterialsshop.model.entity.RoleEntity;
import com.example.educationalmaterialsshop.model.entity.UserEntity;
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
        List<PermissionEntity> all = permissionRepository.findAll();
        if (all.isEmpty()){
            permissionRepository.saveAll(List.of(
                    new PermissionEntity("CREATE"),
                    new PermissionEntity("READ"),
                    new PermissionEntity("UPDATE"),
                    new PermissionEntity("DELETE")
                    ));
        }
        if (roleRepository.findAll().isEmpty()){
            roleRepository.saveAll(List.of(
                    new RoleEntity("SUPER_ADMIN"),
                    new RoleEntity("ADMIN"),
                    new RoleEntity("USER")
            ));
        }
        if (!userRepository.findByUsername("superAdmin").isPresent()){
            UserEntity userEntity = UserEntity.builder()
                    .firstName("Asrorbek")
                    .lastName("Obidjonov")
                    .username("superAdmin")
                    .password("superAdmin")
                    .permissionEntities(permissionRepository.findByNameIn(List.of("CREATE", "READ", "UPDATE", "DELETE")).get())
                    .roleEntities(List.of(roleRepository.findByName("SUPER_ADMIN").get()))
                    .address("Fergana")
                    .postalCode("123456")
                    .phoneNumber("+998949209920")
                    .build();
            userRepository.save(userEntity);
        }
    }
}
