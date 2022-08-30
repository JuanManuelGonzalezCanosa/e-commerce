package com.demo.ecommerce.exceptions;

public class ErrorOrderItemIsNotEnabled extends RuntimeException{

    public ErrorOrderItemIsNotEnabled(){
        super("El Producto NO esta habilitado");
    }
}
