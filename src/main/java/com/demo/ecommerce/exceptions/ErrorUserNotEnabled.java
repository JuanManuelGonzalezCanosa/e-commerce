package com.demo.ecommerce.exceptions;

public class ErrorUserNotEnabled extends RuntimeException{

    public ErrorUserNotEnabled(){
        super("User in NOT enabled");
    }
}
