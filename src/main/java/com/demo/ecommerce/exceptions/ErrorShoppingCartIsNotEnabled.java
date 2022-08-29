package com.demo.ecommerce.exceptions;

public class ErrorShoppingCartIsNotEnabled extends Exception{
    public ErrorShoppingCartIsNotEnabled(){
        super("Error el Carrito NO esta habilotado");
    }
}
