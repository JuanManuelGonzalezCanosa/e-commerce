package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("IShoppingCartRepository")
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
