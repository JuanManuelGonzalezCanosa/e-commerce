package com.demo.ecommerce.controllers;

import com.demo.ecommerce.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService serviceOrderItem;


    //HACERLO DE TIPO RESPONSE ENTITY
    @DeleteMapping("/{id}")
    public boolean deleteOrderItem(@PathVariable Integer id){

        try {
            return serviceOrderItem.deleteOrderItem(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
