package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductsController {
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public List<Product> lstProduct() {
        return service.lstProduct();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return service.getProductById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(service.createProduct(product), HttpStatus.OK);
    }

    @PutMapping("/put/{id}")
    public boolean putProductById(@RequestBody Product product, @PathVariable Integer id){
        return service.putProductById(product, id);
    }

    @PutMapping("/delete/{id}")
    public  boolean deleteProductById(@PathVariable Integer id){
        return service.deleteProductById(id);
    }


}
