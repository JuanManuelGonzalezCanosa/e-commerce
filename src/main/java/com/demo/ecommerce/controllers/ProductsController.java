package com.demo.ecommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @RequestMapping("/categories/all")
    public String GetCategories(){
        return "Put your product list here!";
    }

    @RequestMapping("/category/{id}")
    public String GetCategoryById(int id){
        return "Put your product list here!";
    }
}
