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


    @PostMapping("/create/idProduct/{idProduct}/quantity/{quantity}")
    public ResponseEntity<?> createOrderItem(@PathVariable Integer idProduct, @PathVariable Integer quantity) {
        // ENTIDAD O OBJETO???
        Product product = restTemplate.getForEntity("http://localhost:8080/product/"+ idProduct.toString(), Product.class);


        return service.createOrderItem(product, quantity);
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
    @DeleteMapping("/delete/{id}")
    public boolean deleteOrderItem(@PathVariable Integer id){

        try {
            return service.deleteOrderItem(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
