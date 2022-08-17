package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Category;
import com.demo.ecommerce.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryService {

    private ICategoryRepository repository;

    public List<Category> getCategoryAll (){

        return repository.findAll();
    }

    public Category getCategoryById(Integer id){

        return repository.findById(id).get();
    }

}
