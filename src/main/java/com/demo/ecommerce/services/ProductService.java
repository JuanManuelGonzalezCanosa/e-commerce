package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productService")
public class ProductService{
    @Qualifier("IProductRepository")
    @Autowired
    private IProductsRepository repository;

    public Product saveProduct(Product product){


        return repository.save(product);
    }

    public List<Product> getProductAll (){


        return repository.findAll();
    }

    public Product getProductsById (Integer id){

        return repository.findById(id).get();
    }

}
