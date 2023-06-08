package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByUsernameAndIdNot(String username,int id);
    boolean existsByPhoneNumberAndIdNot(String username,int id);

}
