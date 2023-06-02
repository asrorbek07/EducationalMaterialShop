package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Integer> {
    Optional<PermissionEntity> findByName(String name);
    Optional<List<PermissionEntity>> findByNameIn(List<String> names);
}
