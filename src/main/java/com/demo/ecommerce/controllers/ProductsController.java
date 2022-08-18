package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductsController {


    private ProductService service;

    public Product saveProduct(@RequestBody Product product){

        return service.saveProduct(product);
    }

    @RequestMapping("/product/all")
    public List<Product> getProductAll(){

        return service.getProductAll();
    }

    @RequestMapping("/product/{id}")
    public Product getProductsById(@RequestParam int id){

        return service.getProductsById(id);
    }
}
