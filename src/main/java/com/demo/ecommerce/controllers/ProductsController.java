package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    private ProductService service;

    @RequestMapping("/product/all")
    public List<Product> getsProducts(){

        return service.getsProducts();
    }

    @RequestMapping("/product/{id}")
    public Product getProductsById(int id){

        return service.getProductsById(id);
    }
}
