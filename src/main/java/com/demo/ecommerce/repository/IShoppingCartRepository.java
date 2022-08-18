package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    ShoppingCart saveToCart(ShoppingCart product);

}
