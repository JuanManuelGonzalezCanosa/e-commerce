package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("IShoppingCartItemRepository")
public interface IShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {
}