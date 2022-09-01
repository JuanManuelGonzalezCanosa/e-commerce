package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.exceptions.ErrorOrderItemIsNotEnabled;
import com.demo.ecommerce.exceptions.ErrorQuantityProductNegative;
import com.demo.ecommerce.exceptions.ErrorShoppingCartIsNotEnabled;
import com.demo.ecommerce.exceptions.StockEception;
import com.demo.ecommerce.repository.IOrderItemRepository;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import com.demo.ecommerce.util.ShoppingCartProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {

    @Autowired
    @Qualifier("IShoppingCartRepository")
    private IShoppingCartRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Autowired
    @Qualifier("IOrderItemRepository")
    private IOrderItemRepository repositoryIOrderItem;

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

        aux.setLstOrderItem(shoppingCart.getLstOrderItem());
        aux.setTotal(shoppingCart.getTotal());
        aux.setStatus(shoppingCart.isStatus());

        return true;
    }

    public boolean deleteShoppingCartId(Integer id) {
        repository.deleteById(id);

        return true;
    }

    public ShoppingCart addProductToShoppingCart(OrderItem orderItem, Integer id) throws Exception {

        //CREO AUXILIARES DE CARRITO Y PRODUCTO
        ShoppingCart shoppingCart = repository.findById(id).get(); //mock

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart);

        shoppingCartProxy.addOrderItem(orderItem);

        return this.repository.save(shoppingCartProxy.getShoppingCart());
    }

    public ShoppingCart outProductByCarritoShopping(Integer idShopoingCart, Integer idOrderItem) throws Exception {
        ShoppingCart shoppingCart = repository.findById(idShopoingCart).get(); //mock

        ShoppingCartProxy shoppingCartProxy = new ShoppingCartProxy(shoppingCart,repository);

        shoppingCartProxy.removerOrderItem(idOrderItem);
        return this.repository.save(shoppingCartProxy.getShoppingCart());
    }




}
