package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("IOrderItemRepository")
public interface IOrderItemRepository extends JpaRepository<Product, Integer> {
}