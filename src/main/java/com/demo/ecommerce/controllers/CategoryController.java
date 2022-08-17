package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entities.Category;
import com.demo.ecommerce.services.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService service;

    @RequestMapping("/category/all")
    public List<Category> getsCategory(){

        return service.getsCatrgory();
    }

    @RequestMapping("/category/{id}")
    public Category getCategoryById(int id){

        return service.getCategoryById(id);
    }
}