package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.services.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RequestMapping("/shoppingcartitem")
@RestController
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService service;

    private RestTemplate restTemplate;

    @Autowired
    public ShoppingCartItemController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @PostMapping("/create/idproduct/{idProduct}/quantity/{quantity}")
    public ResponseEntity<?> createShoppingCartItem(@PathVariable Integer idProduct, @PathVariable Integer quantity) {
        ResponseEntity<Product> response = restTemplate.getForEntity("http://localhost:8080/product/"+ idProduct.toString(), Product.class);

        if(response.getStatusCode().value() >= 200 && response.getStatusCode().value() < 300){
            Product product = response.getBody();
            service.createShoppingCartItem(product, quantity);
            return ResponseEntity.ok().body("Ok");
        }

        return ResponseEntity.badRequest().body("Error Producto no Encontrado");
    }

    @GetMapping("/all")
    public List<ShoppingCartItem> lstOrderItem(){
        try {
            return service.lstOrderItem();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    //PREGUNTAR COMO ES EN ESTOS CASOS
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

    @DeleteMapping("/delete/{id}")
    public boolean deleteOrderItem(@PathVariable Integer id){

        try {
            return service.deleteOrderItem(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
