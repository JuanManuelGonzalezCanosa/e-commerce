package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import com.demo.ecommerce.util.ShoppingCartProxy;
import com.demo.ecommerce.util.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    @Qualifier("IShoppingCartRepository")
    private IShoppingCartRepository repository;


    public ShoppingCart createToCart(ShoppingCart shoppingCart, User user) {

        shoppingCart.setUser(user);

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

    @Transactional
    public ShoppingCart addProductToShoppingCart(User user, ShoppingCartItem shoppingCartItem, Integer id) throws Exception {

        //CREO AUXILIARES DE CARRITO Y PRODUCTO
        ShoppingCart shoppingCart = repository.findById(id).get(); //mock

        UserProxy userCartProxy = new UserProxy(user, shoppingCart);

        userCartProxy.addOrderItem(shoppingCartItem);


        ShoppingCart shoppingCartUpdated = this.repository.save(userCartProxy.getShoppingCart());


        //todo descuento stock! Api call descontar Item,

        return shoppingCartUpdated;


    }

    public ShoppingCart outProductByCarritoShopping(Integer idShopoingCart, Integer idOrderItem) throws Exception {
        ShoppingCart shoppingCart = repository.findById(idShopoingCart).get(); //mock

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart);

        shoppingCartProxy.removerOrderItem(idOrderItem);
        return this.repository.save(shoppingCartProxy.getShoppingCart());
    }

    public boolean deleteShoppingCartId(ShoppingCart shoppingCart) throws Exception {

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart);

        shoppingCartProxy.deleteShopping();

        this.repository.delete(shoppingCart);

        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCart buy(Integer idShoppingCart, RestTemplate restTemplate){

        ShoppingCart shoppingCart = this.getShoppingCartById(idShoppingCart);
        shoppingCart.getLstShoppingCartItem().stream().forEach( lstShoppingCartItem -> {
            restTemplate.put("http://localhost:8080/update-stock/" + lstShoppingCartItem.getItem().getId() + "/quantity/" + lstShoppingCartItem.getQuantity(), Boolean.class);
        });

        shoppingCart.setStatus(false);

        return repository.save(shoppingCart);
    }




}
