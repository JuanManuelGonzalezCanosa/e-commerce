package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.enumerados.Roles;
import com.demo.ecommerce.repository.IProductsRepository;
import com.demo.ecommerce.repository.IShoppingCartItemRepository;
import com.demo.ecommerce.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {


    @Autowired
    @Qualifier("IProductRepository")
    IProductsRepository repositoryProduct;

    @Autowired
    @Qualifier("IOrderItemRepository")
    IShoppingCartItemRepository repositoryOrderItem;

    @Mock
    private IUserRepository repository;

    @InjectMocks
    UserService userService;

    private User user;

    public UserTest(User user) {
        this.user = user;
    }




    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);

        Product product = new Product(1, "Sandia", "Fruta", 200, "asd", 250, true, true);
        repositoryProduct.save(product);
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(1, product, 20);
        repositoryOrderItem.save(shoppingCartItem);
        List<ShoppingCartItem> list = new ArrayList<>();
        list.add(shoppingCartItem);
        //ShoppingCart shoppingCart = new ShoppingCart(1, list, 4500.0, true);

        user = new User();
        user.setId(1);
        user.setName("juan");
        user.setPassword("12345");
        //user.setShoppingCart((List<ShoppingCart>) shoppingCart);
        user.setActive(true);
        user.setRol(Roles.ADMIN);

        //ESTE ES EL USUARIO CON EL QUE VAMOS A TESTEAR
        repository.save(user);

    }



}
