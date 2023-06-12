package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<List<Product>> findAllByCategory_Id(int id);
    boolean existsByName(String name);

    boolean existsByIsbn(int isbn);

    boolean existsByNameAndIdNot(String name, int id);
}
