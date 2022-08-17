package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productsRepository")
public interface IProductsRepository extends JpaRepository<Product, Integer> {
}
