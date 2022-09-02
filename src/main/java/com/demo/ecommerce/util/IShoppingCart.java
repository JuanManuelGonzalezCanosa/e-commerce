package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;

public interface IShoppingCart {
    void addOrderItem(OrderItem orderItem) throws Exception;
    void removerOrderItem(Integer idOrderItem) throws Exception;
    void removeShopping(ShoppingCart shoppingCart)throws Exception;
    //void save();
}
