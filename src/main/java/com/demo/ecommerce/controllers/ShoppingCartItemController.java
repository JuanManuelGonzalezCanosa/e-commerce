package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.services.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/shoppingcartitem")
@RestController
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService service;


    @PostMapping("/create")
    public ShoppingCartItem createOrderItem(@RequestBody ShoppingCartItem shoppingCartItem) {
        return service.createOrderItem(shoppingCartItem);
    }

    @GetMapping("/all")
    public List<ShoppingCartItem> lstOrderItem(){
        try {
            return service.lstOrderItem();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ShoppingCartItem orderItemId(@PathVariable Integer id){
        try {
            return service.getOrderItemById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/put/{id}")
    public ShoppingCartItem putOrderItemById(@RequestBody ShoppingCartItem shoppingCartItem, @PathVariable Integer id){
        try {
            return service.putOrderItemById(shoppingCartItem, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //HACERLO DE TIPO RESPONSE ENTITY
    @DeleteMapping("/{id}")
    public boolean deleteOrderItem(@PathVariable Integer id){

        try {
            return service.deleteOrderItem(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
