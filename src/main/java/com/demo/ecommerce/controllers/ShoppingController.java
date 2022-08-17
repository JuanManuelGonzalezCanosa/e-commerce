package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.services.IShopingCartService;
import com.demo.ecommerce.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    @Autowired
    @Qualifier("IShopping")
    private IShopingCartService service;

    @GetMapping
    public addProduct(@RequestBody Product product){
        service.addToCart(product);
    }

    // agrgear
    //eliminar
    //cambiar estado
}
