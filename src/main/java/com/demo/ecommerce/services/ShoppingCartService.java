package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import com.demo.ecommerce.util.ShoppingCartProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    @Qualifier("IShoppingCartRepository")
    private IShoppingCartRepository repository;


    public ShoppingCart createToCart(ShoppingCart shoppingCart) {
        return repository.save(shoppingCart);
    }

    public List<ShoppingCart> lstShoppingCart() {
        return repository.findAll();
    }

    public ShoppingCart getShoppingCartById(Integer id) {
        return repository.findById(id).get();
    }

    public boolean putShoppingCartById(ShoppingCart shoppingCart, Integer id) {
        ShoppingCart aux = this.getShoppingCartById(id);

        aux.setLstShoppingCartItem(shoppingCart.getLstShoppingCartItem());
        aux.setTotal(shoppingCart.getTotal());
        aux.setStatus(shoppingCart.isStatus());

        return true;
    }

    public ShoppingCart addProductToShoppingCart(ShoppingCartItem shoppingCartItem, Integer id) throws Exception {

        //CREO AUXILIARES DE CARRITO Y PRODUCTO
        ShoppingCart shoppingCart = repository.findById(id).get(); //mock

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart);

        shoppingCartProxy.addOrderItem(shoppingCartItem);

        return this.repository.save(shoppingCartProxy.getShoppingCart());
    }

    public ShoppingCart outProductByCarritoShopping(Integer idShopoingCart, Integer idOrderItem) throws Exception {
        ShoppingCart shoppingCart = repository.findById(idShopoingCart).get(); //mock

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart);

        shoppingCartProxy.removerOrderItem(idOrderItem);
        return this.repository.save(shoppingCartProxy.getShoppingCart());
    }

    public boolean deleteShoppingCartId(ShoppingCart shoppingCart) throws Exception {

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart);

        shoppingCartProxy.removeShopping();

        this.repository.delete(shoppingCart);

        return true;
    }




}
