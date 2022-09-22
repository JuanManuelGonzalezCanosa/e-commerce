package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.exceptions.ProducNotFound;
import com.demo.ecommerce.exceptions.StockEception;
import com.demo.ecommerce.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Qualifier("ProductService")
public class ProductService {
    @Qualifier("IProductRepository")
    @Autowired
    private IProductsRepository repository;

    public Product createProduct(Product product) {return repository.save(product);}

    public List<Product> lstProduct() {
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.findById(id).get();
    }


    public Product putProductById(Product product, Integer id) {

        Product aux = this.getProductById(id);

        aux.setName(product.getName());
        aux.setEnabled(product.isEnabled());
        aux.setPromotion(product.isPromotion());
        aux.setStock(product.getStock());
        aux.setDescription(product.getDescription());
        aux.setPrice(product.getPrice());
        aux.setPhotoURL(product.getPhotoURL());

        return repository.save(aux);
    }

    public boolean deleteProductById(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Transactional(propagation = Propagation.NESTED)
    public Product updateStock(Integer productId, Integer quantity) {
        Product product = repository.findById(productId).orElseThrow(() -> new ProducNotFound(productId));
        product.setStock(product.getStock() - quantity);
        if (product.getStock() < 0) throw new StockEception();
        repository.save(product);

        return product;
    }
}
