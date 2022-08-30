package com.demo.ecommerce.exceptions;

public class ShoppingCartNotFound extends RuntimeException {

    public ShoppingCartNotFound() {
        super("Shopping cart not exists");
    }
}
