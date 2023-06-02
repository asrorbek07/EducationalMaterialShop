package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public Optional<UserEntity> findByUsername(String username);
    public Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
