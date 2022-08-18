package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productsRepository")
public interface IProductsRepository extends JpaRepository<Product, Integer> {

    public Product saveProduct(Product product);
    public List<Product> getProductAll ();
    public Product getProductsById (Integer id);
}
