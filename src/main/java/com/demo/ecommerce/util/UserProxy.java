package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.ShoppingCart;

import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.exceptions.ErrorShoppingCartIsNotEnabled;
import com.demo.ecommerce.exceptions.ErrorUserNotEnabled;
import com.demo.ecommerce.exceptions.ListEmpty;

public class UserProxy implements IUser{

    private final User user;

    public UserProxy(User user){this.user = user;}

    @Override
    public void addShoppingCart(ShoppingCart shoppingCart) throws Exception {
        if(!shoppingCart.isStatus()){
            throw new ErrorShoppingCartIsNotEnabled();
        }

        if(!user.isActive()){
            throw new ErrorUserNotEnabled();
        }

        user.getShoppingCart().add(shoppingCart);

    }

    @Override
    public void removeShoppingCart(User user) throws Exception {
        if(!user.getShoppingCart().isEmpty()){
            throw new ListEmpty();
        }



    }

    public User getUser() {
        return user;
    }

}
