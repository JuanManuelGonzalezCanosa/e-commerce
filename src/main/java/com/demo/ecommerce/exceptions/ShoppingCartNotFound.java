package com.demo.ecommerce.exceptions;

public class ShoppingCartNotFound extends Exception {

    public ShoppingCartNotFound() {
        super("Shopping cart not exists");
    }
}
