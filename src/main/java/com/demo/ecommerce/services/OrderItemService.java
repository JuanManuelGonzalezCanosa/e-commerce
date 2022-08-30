package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.Product;
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

    public List<OrderItem> lstOrderItem() {
        return repositoryIOrderItem.findAll();
    }

    public OrderItem getOrderItemById(Integer id) {

        return repositoryIOrderItem.findById(id).get();
    }


    public OrderItem putOrderItemById(OrderItem orderItem, Integer id) {

        OrderItem aux = this.getOrderItemById(id);

        aux.setItem(orderItem.getItem());
        aux.setQuantity(orderItem.getQuantity());

        return repositoryIOrderItem.save(aux);
    }

    public boolean deleteOrderItem(Integer id) throws Exception{

        if(!repositoryIOrderItem.findById(id).isPresent()){
            //CREAR LA CLASE DE EXCEPCION
            //throw new Exception();
        }
        repositoryIOrderItem.deleteById(id);
        return true;
    }
}

