package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductsController {
    @Autowired
    private ProductService service;

    //Ver manejo de excepciones.
   // @ExceptionHandler(value = StockEception.class) {
     //   public ResponseEntity badReques (Exception e){
       //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST, e.getMessage());
        //}
    //}

    @GetMapping("/product/all")
    public List<Product> lstProduct() {
        return service.lstProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id) {
        System.out.println(id);
        return service.getProductById(id);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(service.createProduct(product), HttpStatus.OK);
    }

    @PutMapping("/putProduct/{id}")
    public boolean putProductById(@RequestBody Product product, @PathVariable Integer id){
        return service.putProductById(product, id);
    }

    @PutMapping("/deleteProduct/{id}")
    public  boolean deleteProductById(@PathVariable Integer id){
        return service.deleteProductById(id);
    }


}
