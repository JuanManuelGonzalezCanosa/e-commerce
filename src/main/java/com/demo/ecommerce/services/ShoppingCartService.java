package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("IShopping")
@Service
public class ShoppingCartService{

    @Autowired
    @Qualifier("IShoppingCartRepository")
    private IShoppingCartRepository repository;

    //public ShoppingCart saveToCart(ShoppingCart shoppingCart) {
      //  return repository.save(shoppingCart);
    //}

    public ShoppingCart addProduct(List<Product> product, Integer id) {

        //chequear si esta activo.
        //cheque si tiene descuento y restar 10% al total.

        // isEnabled(product)
        // isPromotion(product)/

        ShoppingCart aux = repository.findById(id).get();

        aux.getLstProduct().addAll(product);

        return repository.save(aux);
    }
}
