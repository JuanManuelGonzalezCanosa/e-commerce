package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
