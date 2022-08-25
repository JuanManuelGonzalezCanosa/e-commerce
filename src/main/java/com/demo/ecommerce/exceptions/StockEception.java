package com.demo.ecommerce.exceptions;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

public class StockEception extends Exception {
    StockEception(AbstractReadWriteAccess.Item item) {
        super("No Hay Stock para el item...." + item.getId());
    }
}
