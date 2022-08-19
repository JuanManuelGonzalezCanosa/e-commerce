package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("productService")
public class ProductService{
    @Qualifier("IProductRepository")
    @Autowired
    private IProductsRepository repository;

    public Product createProduct(Product product){
        return repository.save(product);
    }

    public Set<Product> lstProduct (){
        return (Set<Product>) repository.findAll();
    }

    public Product getProductById (Integer id){
        return repository.findById(id).get();
    }

}
