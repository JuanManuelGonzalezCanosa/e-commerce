package com.demo.ecommerce.exceptions;

public class ErrorOrderItemIsNotEnabled extends Exception{

    public ErrorOrderItemIsNotEnabled(){
        super("El Producto NO esta habilitado");
    }
}
