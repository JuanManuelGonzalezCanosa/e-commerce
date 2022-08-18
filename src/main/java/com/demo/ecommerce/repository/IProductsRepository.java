package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("IProductRepository")
public interface IProductsRepository extends JpaRepository<Product, Integer> {

}
