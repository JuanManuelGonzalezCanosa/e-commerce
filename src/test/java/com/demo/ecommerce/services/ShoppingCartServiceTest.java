package com.demo.ecommerce.services;

import com.demo.ecommerce.controllers.ShoppingCartController;
import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.Product;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartServiceTest {

    @Test
    public void given_item_with_price_4500_shoul_get_a_sum_of_4500() throws Exception {

        double result = 4500.0;

        ShoppingCartService shoppingCartService = new ShoppingCartService();
        Product product = new Product(1,"Sandia", "Fruta", 200, "asd", 250, true, true);
        OrderItem orderItem = new OrderItem(1, product, 20);


        Assert.assertEquals(result, shoppingCartService.addProductToShoppingCart(orderItem, 1).getTotal(), 0.001);
    }
}
