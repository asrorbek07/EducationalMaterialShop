package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    Permission findByName(String name);
    List<Permission> findByNameIn(List<String> names);
}
