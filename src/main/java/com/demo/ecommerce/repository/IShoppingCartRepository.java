package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    public ShoppingCart saveToCart(ShoppingCart product);

    public ShoppingCart addProduct(Product product);
}
