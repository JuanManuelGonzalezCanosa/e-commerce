package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.ShoppingCart;


public interface IUser {

    void addShoppingCart(ShoppingCart shoppingCart) throws Exception;
    void removerShoppingCart(Integer idOrderItem) throws Exception;
}
