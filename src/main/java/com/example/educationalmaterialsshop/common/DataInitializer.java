package com.example.educationalmaterialsshop.common;

import com.example.educationalmaterialsshop.model.entity.Permission;
import com.example.educationalmaterialsshop.model.entity.Role;
import com.example.educationalmaterialsshop.model.entity.Supplier;
import com.example.educationalmaterialsshop.model.entity.User;
import com.example.educationalmaterialsshop.repository.PermissionRepository;
import com.example.educationalmaterialsshop.repository.RoleRepository;
import com.example.educationalmaterialsshop.repository.SupplierRepository;
import com.example.educationalmaterialsshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final SupplierRepository supplierRepository;

    @Override

    public void run(String... args) throws Exception {
        List<Permission> all = permissionRepository.findAll();
        if (all.isEmpty()) {
            permissionRepository.saveAll(List.of(
                    new Permission("CREATE"),
                    new Permission("READ"),
                    new Permission("UPDATE"),
                    new Permission("DELETE")
            ));
        }
        if (roleRepository.findAll().isEmpty()) {
            roleRepository.saveAll(List.of(
                    new Role("SUPER_ADMIN"),
                    new Role("ADMIN")
            ));
        }
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = User.builder()
                    .firstName("Asrorbek")
                    .lastName("Obidjonov")
                    .username("admin")
                    .password("admin")
                    .permissionEntities(permissionRepository.findByNameIn(List.of("CREATE", "READ", "UPDATE", "DELETE")))
                    .roleEntities(List.of(roleRepository.findByName("ADMIN")))
                    .address("Fergana")
                    .phoneNumber("+998949209920")
                    .date(Instant.now())
                    .build();
            userRepository.save(user);
        }
        if (supplierRepository.findAll().isEmpty()){
            supplierRepository.saveAll(List.of(
                    Supplier.builder()
                            .fullName("Bekzodbek")
                            .phoneNumber("+998909909090")
                            .address("Farg'ona")
                            .company("White Paper")
                            .date(Instant.now())
                            .build(),
                    Supplier.builder()
                            .fullName("Alijon")
                            .phoneNumber("+998944443434")
                            .address("Toshkent")
                            .company("Best Pen")
                            .date(Instant.now())
                            .build()
            ));
        }
    }
}
