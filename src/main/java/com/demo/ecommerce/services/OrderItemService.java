package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.repository.IOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    @Qualifier("IOrderItemRepository")
    private IOrderItemRepository repositoryIOrderItem;



}
