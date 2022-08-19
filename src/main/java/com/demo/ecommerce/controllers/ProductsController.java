package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
public class ProductsController{
    @Autowired
    private ProductService service;

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }

    @GetMapping("/product/all")
    public Set<Product> lstProduct(){
        return service.lstProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        System.out.println(id);
        return service.getProductById(id);
    }

}
