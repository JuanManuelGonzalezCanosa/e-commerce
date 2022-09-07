package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.entities.ShoppingCart;

public interface IShoppingCart {
    void addOrderItem(ShoppingCartItem shoppingCartItem) throws Exception;
    void removerOrderItem(Integer idOrderItem) throws Exception;
    void removeShopping()throws Exception;
    //void save();
}
