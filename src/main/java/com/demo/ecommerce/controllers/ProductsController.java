package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
public class ProductsController{
    @Autowired
    private ProductService service;

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        try{
            return new ResponseEntity<Product>(service.createProduct(product), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product/all")
    public List<Product> lstProduct(){
        return service.lstProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        System.out.println(id);
        return service.getProductById(id);
    }

}
