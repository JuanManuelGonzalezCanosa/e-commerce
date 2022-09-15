package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.User;


public interface IUser {

    void addShoppingCart(User user, ShoppingCart shoppingCart) throws Exception;
    void removeShoppingCart(User user, ShoppingCart shoppingCart) throws Exception;
}
