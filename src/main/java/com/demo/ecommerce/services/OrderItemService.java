package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.exceptions.IdNotFound;
import com.demo.ecommerce.exceptions.ListEmpty;
import com.demo.ecommerce.repository.IOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    @Qualifier("IOrderItemRepository")
    private IOrderItemRepository repositoryIOrderItem;


    public OrderItem createOrderItem(OrderItem orderItem) {

        //verificar que este activo.
        return repositoryIOrderItem.save(orderItem);
    }

    public List<OrderItem> lstOrderItem() throws Exception {

        if(repositoryIOrderItem.findAll().isEmpty()){
            throw new Exception(new ListEmpty().getMessage());
        }

        return repositoryIOrderItem.findAll();
    }

    public OrderItem getOrderItemById(Integer id) throws Exception {

        if(!repositoryIOrderItem.findById(id).isPresent()){
            throw new Exception(new IdNotFound().getMessage());
        }

        return repositoryIOrderItem.findById(id).get();
    }


    public OrderItem putOrderItemById(OrderItem orderItem, Integer id) throws Exception {

        OrderItem aux = this.getOrderItemById(id);

        aux.setItem(orderItem.getItem());
        aux.setQuantity(orderItem.getQuantity());

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

