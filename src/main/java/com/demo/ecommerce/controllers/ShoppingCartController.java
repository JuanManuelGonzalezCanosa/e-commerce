package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.services.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingCartController {

    private ShoppingCartService service;

    @GetMapping("/shoppingCartAll")
    public List<ShoppingCart> getShoppingCartAll(){

        return null;
    }

    @PostMapping("/addShoppingCart")
    public ShoppingCart saveShopingCart(@RequestBody ShoppingCart shoppingCart){

        return service.saveToCart(shoppingCart);
    }


}
