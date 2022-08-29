package com.demo.ecommerce.exceptions;

public class ErrorQuantityProductNegative extends Exception{

    public ErrorQuantityProductNegative(){
        super("Error los Productos no puden ser negativos");
    }
}
