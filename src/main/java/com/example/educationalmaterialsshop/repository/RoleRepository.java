package com.example.educationalmaterialsshop.repository;


import com.example.educationalmaterialsshop.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
