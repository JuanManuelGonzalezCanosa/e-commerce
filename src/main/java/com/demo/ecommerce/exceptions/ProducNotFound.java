package com.demo.ecommerce.exceptions;

public class ProducNotFound extends RuntimeException {
    public ProducNotFound(Integer productId) {
        super(productId.toString());
    }
}
