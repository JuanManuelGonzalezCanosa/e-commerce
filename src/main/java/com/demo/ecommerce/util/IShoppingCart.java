package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.OrderItem;

public interface IShoppingCart {
    void addOrderItem(OrderItem orderItem) throws Exception;
    void removerOrderItem(Integer idOrderItem) throws Exception;
    //void save();
}
