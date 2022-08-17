package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("IShopping")
@Service
public class ShoppingCartService implements IShopingCartService{

    @Autowired
    private IShopingCartRepository repository;

    @Override
    public void addToCart(Product product) {

        //chequear si esta activo.
        //cheque si tiene descuento y restar 10% al total.
        IShopingCartRepository.add(product);
    }
}
