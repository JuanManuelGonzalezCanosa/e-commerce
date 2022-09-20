package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.exceptions.IdNotFound;
import com.demo.ecommerce.exceptions.ListEmpty;
import com.demo.ecommerce.repository.IShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemService {

    @Autowired
    @Qualifier("IShoppingCartItemRepository")
    private IShoppingCartItemRepository repositoryIOrderItem;


    public ShoppingCartItem createShoppingCartItem(Product product, Integer quantity) {
        ShoppingCartItem aux = new ShoppingCartItem();


        aux.setItem(product);
        aux.setQuantity(quantity);


        return repositoryIOrderItem.save(aux);
    }

    public List<ShoppingCartItem> lstOrderItem() throws Exception {

        if(repositoryIOrderItem.findAll().isEmpty()){
            throw new Exception(new ListEmpty().getMessage());
        }

        return repositoryIOrderItem.findAll();
    }

    public ShoppingCartItem getOrderItemById(Integer id) throws Exception {

        if(!repositoryIOrderItem.findById(id).isPresent()){
            throw new Exception(new IdNotFound().getMessage());
        }

        return repositoryIOrderItem.findById(id).get();
    }


    public ShoppingCartItem putOrderItemById(ShoppingCartItem shoppingCartItem, Integer id) throws Exception {

        ShoppingCartItem aux = this.getOrderItemById(id);

        aux.getItem();
        aux.setQuantity(shoppingCartItem.getQuantity());

        return repositoryIOrderItem.save(aux);
    }

    public boolean deleteOrderItem(Integer id) throws Exception{

        if(!repositoryIOrderItem.findById(id).isPresent()){
            throw new Exception(new IdNotFound().getMessage());
        }
        repositoryIOrderItem.deleteById(id);
        return true;
    }
}

