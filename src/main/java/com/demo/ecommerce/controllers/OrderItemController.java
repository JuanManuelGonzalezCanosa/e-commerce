package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService serviceOrderItem;


    @PostMapping("/create")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        return serviceOrderItem.createOrderItem(orderItem);
    }

    @GetMapping("/all")
    public List<OrderItem> lstOrderItem(){
        try {
            return serviceOrderItem.lstOrderItem();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public OrderItem orderItemId(@PathVariable Integer id){
        try {
            return serviceOrderItem.getOrderItemById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/put/{id}")
    public OrderItem putOrderItemById(@RequestBody OrderItem orderItem, @PathVariable Integer id){
        try {
            return serviceOrderItem.putOrderItemById(orderItem, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //HACERLO DE TIPO RESPONSE ENTITY
    @DeleteMapping("/{id}")
    public boolean deleteOrderItem(@PathVariable Integer id){

        try {
            return serviceOrderItem.deleteOrderItem(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
