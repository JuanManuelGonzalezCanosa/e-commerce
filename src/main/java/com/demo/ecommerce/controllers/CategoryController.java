package com.demo.ecommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @RequestMapping("/category/all")
    public String GetProducts(){
        return "Put your product list here!";
    }

    @RequestMapping("/category/{id}")
    public String GetProductById(int id){
        return "Put your product list here!";
    }
}