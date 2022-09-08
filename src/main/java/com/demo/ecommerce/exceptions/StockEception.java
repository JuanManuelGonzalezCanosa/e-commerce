package com.demo.ecommerce.exceptions;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

public class StockEception extends RuntimeException {
    public StockEception() {
        super("No Hay Stock");
    }
}
