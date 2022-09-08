package com.demo.ecommerce.exceptions;

public class ErrorShoppingCartIsNotEnabled extends RuntimeException{
    public ErrorShoppingCartIsNotEnabled(){
        super("Error el Carrito NO esta habilitado");
    }
}
