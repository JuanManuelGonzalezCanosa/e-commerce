package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.RequestProducts;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
    public ShoppingCart addProductToShoppingCart(@RequestBody RequestProducts requestProducts, @PathVariable Integer id){

        try {
            return service.addProductToShoppingCart(requestProducts.idProduct, requestProducts.quantityOfProducts, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
