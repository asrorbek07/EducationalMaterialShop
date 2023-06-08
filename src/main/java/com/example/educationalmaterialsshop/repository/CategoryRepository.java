package com.example.educationalmaterialsshop.repository;

import com.example.educationalmaterialsshop.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, int id);
}
