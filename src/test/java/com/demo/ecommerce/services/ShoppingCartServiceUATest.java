package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.repository.IProductsRepository;
import com.demo.ecommerce.repository.IShoppingCartItemRepository;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceUATest {


    @Autowired
    @Qualifier("IShoppingCartRepository")
    IShoppingCartRepository repository;

    @Autowired
    @Qualifier("IProductRepository")
    IProductsRepository repositoryProduct;

    @Autowired
    @Qualifier("IOrderItemRepository")
    IShoppingCartItemRepository repositoryOrderItem;
    @Autowired
    ShoppingCartService shoppingCartService;

    ShoppingCart shoppingCart;

    //given orderItem & ShoppingCartId  when   save carrito then carrito deberia ser guardado y actualizado el total.
    @Before
    public void init() {

        Product product = new Product(1, "Sandia", "Fruta", 200, "asd", 250, true, true);
        repositoryProduct.save(product);
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(1, product, 20);
        repositoryOrderItem.save(shoppingCartItem);
        List<ShoppingCartItem> list = new ArrayList<>();
        list.add(shoppingCartItem);
        this.shoppingCart = new ShoppingCart(1, list, 4500.0, true);

        repository.save(shoppingCart);

    }

    @Test
    public void given_orderItem_and_shippingCartId_should_shopingCart_shpould_save_and_updated() throws Exception {

        //given:
        Product product = new Product(2, "tomate", "fruta", 10, "asd", 10, true, true);
        repositoryProduct.save(product);
        ShoppingCartItem newOrder = new ShoppingCartItem(2, product, 2);
        repositoryOrderItem.save(newOrder);
        Integer shoppingCart = 1;

        // when(repository.findById(any())).thenReturn(Optional.of(shoppingCart));
        //  when(repository.save(any())).thenReturn(shoppingCart);

        //when


        /*
        ShoppingCart actual = shoppingCartService.addProductToShoppingCart(newOrder, shoppingCart);
        ShoppingCart expected = shoppingCartService.getShoppingCartById(1);

        //then:
        //  verify(repository,atLeastOnce()).findById(any());
        //   verify(repository,atLeastOnce()).save(any());
        System.out.println(actual.getTotal());
        assertEquals(expected.getTotal(), actual.getTotal());
       */

    }

}
