package com.demo.ecommerce.exceptions;

public class OrderItemNotFound extends RuntimeException{

    public OrderItemNotFound(){
        super("Order Item not exists");
    }
}

