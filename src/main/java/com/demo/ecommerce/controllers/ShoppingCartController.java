package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @PostMapping("/createShoppingCart")
    public ShoppingCart createToCart(@RequestBody ShoppingCart shoppingCart){
        return service.createToCart(shoppingCart);
    }

    @GetMapping("/shoppingCart/all")
    public List<ShoppingCart> lstShoppingCart(){
        return service.lstShoppingCart();
    }

    @GetMapping("/shoppingCart/{id}")
    public ShoppingCart getShoppingCartById(@PathVariable Integer id){
        return service.getShoppingCartById(id);
    }

    @PostMapping("/addProductToShoppingCart/{id}")
    public ShoppingCart addProductToShoppingCart(@PathVariable Integer idProduct,@PathVariable int quantityOfProducts, @PathVariable Integer id){
        try {
            return service.addProductToShoppingCart(idProduct, quantityOfProducts, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
