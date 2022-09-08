package com.demo.ecommerce.exceptions;

public class ErrorStockNegative extends RuntimeException{

    public ErrorStockNegative(){
        super("El Stock no puede ser Negativo");
    }
}

