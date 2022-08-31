package com.demo.ecommerce.exceptions;

public class IdNotFound extends RuntimeException{

    public IdNotFound(){
        super("Order Item not exists");
    }
}

