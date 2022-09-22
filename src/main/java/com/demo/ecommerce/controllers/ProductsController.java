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


    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try{
            return new ResponseEntity<Product>(service.createProduct(product), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public List<Product> lstProduct() {
        return service.lstProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<Product>(service.getProductById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putProductById(@RequestBody Product product, @PathVariable Integer id) {
        try{
            return new ResponseEntity<Product>(service.putProductById(product, id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-stock/{productId}/quantity/{quantity}")
    public ResponseEntity<?> updateStock(@PathVariable Integer productId, @PathVariable Integer quantity) {
        try{
            return new ResponseEntity<Product>(service.updateStock(productId, quantity), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id) {
        try{
            return new ResponseEntity<>(service.deleteProductById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }


}
