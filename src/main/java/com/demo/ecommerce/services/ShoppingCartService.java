package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.repository.IOrderItemRepository;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService{

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

    public ShoppingCart addProductToShoppingCart(OrderItem orderItem, Integer id) throws Exception {
        //CREO AUXILIARES DE CARRITO Y PRODUCTO
        ShoppingCart auxShoppingCart = repository.findById(id).get(); //mock


        //Refactorizar validacion y llevarlo a ShoppingCart
        if (!orderItem.getItem().isEnabled()) {
            throw new Exception("Is not enabled");
        }


        if (orderItem.getItem().getStock() < orderItem.getQuantity()) {
            throw new Exception("no stock");
        } else {
            //TIENE DESCUENTO?
            if (orderItem.getItem().isPromotion()) {
                orderItem.getItem().setPrice((double) (0.90 * orderItem.getItem().getPrice()));
            }
        }

        auxShoppingCart.addOrderItem(orderItem);

        return repository.save(auxShoppingCart); //mock
    }
}
