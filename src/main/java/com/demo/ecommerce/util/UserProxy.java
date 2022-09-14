package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.enumerados.Roles;
import com.demo.ecommerce.exceptions.ErrorShoppingCartIsNotEnabled;
import com.demo.ecommerce.exceptions.ErrorUserNotEnabled;
import com.demo.ecommerce.exceptions.ListEmpty;

public class UserProxy extends ShoppingCartProxy implements IUser {

    private final User user;

    public UserProxy(User user, ShoppingCart shoppingCart) {
        super(shoppingCart);
        this.user = user;
    }



    @Override
    public void addOrderItem(ShoppingCartItem shoppingCartItem) throws Exception {
        if(user.getRol().equals(Roles.GERENTE)){
            throw new Exception("No Puede Agregar Un Item");
        }

        if(!user.getId().equals(super.getShoppingCart().getUser().getId())){
            throw  new Exception("ERROR: USUARIO DIFERENTE");
        }

        super.addOrderItem(shoppingCartItem);
    }

    @Override
    public void removerOrderItem(Integer idOrderItem) throws Exception {
        super.removerOrderItem(idOrderItem);
    }

    @Override
    public void removeShopping() throws Exception {
        super.removeShopping();
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return super.getShoppingCart();
    }

    public User getUser() {
        return user;
    }

    @Override
    public void addShoppingCart(ShoppingCart shoppingCart) throws Exception {

    }

    @Override
    public void removeShoppingCart(User user) throws Exception {

    }
}
