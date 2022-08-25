package com.demo.ecommerce.services;

import com.demo.ecommerce.controllers.ShoppingCartController;
import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.repository.IOrderItemRepository;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.mockito.Mockito.when;

public class ShoppingCartServiceTest {

    @Mock
    private IShoppingCartRepository repository;
    @Mock
    private IOrderItemRepository repositoryIOrderItem;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void given_item_with_price_4500_shoul_get_a_sum_of_4500() throws Exception {

        double result = 4500.0;

        ShoppingCartService shoppingCartService = new ShoppingCartService();
        Product product = new Product(1,"Sandia", "Fruta", 200, "asd", 250, true, true);
        OrderItem orderItem = new OrderItem(1, product, 20);


        Assert.assertEquals(result, shoppingCartService.addProductToShoppingCart(orderItem, 1).getTotal(), 0.001);
    }


}
