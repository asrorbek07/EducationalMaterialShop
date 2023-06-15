package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input,Integer> {
}
