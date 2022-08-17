package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.repository.IProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductService {

    private IProductsRepository repository;


    public List<Product> getsProducts (){
        return repository.findAll();
    }

    public Product getProductsById (Integer id){

        return repository.findById(id).get();
    }

}
