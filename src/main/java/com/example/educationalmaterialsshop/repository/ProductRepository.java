package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
}
