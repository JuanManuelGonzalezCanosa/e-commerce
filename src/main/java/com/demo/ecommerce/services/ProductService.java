package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("ProductService")
public class ProductService {
    @Qualifier("IProductRepository")
    @Autowired
    private IProductsRepository repository;

    public Product createProduct(Product product) {

        //verificar que este activo.
        return repository.save(product);
    }

    public List<Product> lstProduct() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).get();
    }


    public boolean putProductById(Product product, Integer id) {

        Product aux = this.getProductById(id);

        aux.setName(product.getName());
        aux.setEnabled(product.isEnabled());
        aux.setPromotion(product.isPromotion());
        aux.setStock(product.getStock());
        aux.setDescription(product.getDescription());
        aux.setPrice(product.getPrice());
        aux.setPhotoURL(product.getPhotoURL());

        return  true;
    }

    public boolean deleteProductById(Integer id){
        repository.deleteById(id);
        return true;
    }
}
