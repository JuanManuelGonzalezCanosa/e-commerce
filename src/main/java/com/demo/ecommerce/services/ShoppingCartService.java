package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("IShopping")
@Service
public class ShoppingCartService{

    @Autowired
    private IShoppingCartRepository repository;

    @Autowired
    public ShoppingCart saveToCart(ShoppingCart shoppingCart) {

        //chequear si esta activo.
        //cheque si tiene descuento y restar 10% al total.
        return repository.save(shoppingCart);
    }
}
