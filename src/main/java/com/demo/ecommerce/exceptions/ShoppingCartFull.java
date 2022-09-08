package com.demo.ecommerce.exceptions;

public class ShoppingCartFull extends RuntimeException{

    public ShoppingCartFull() {super("CARRITO LLENO, LO TIENE QUE VACIAR");}
}
