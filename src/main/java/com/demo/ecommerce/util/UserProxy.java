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
            throw new Exception("Tu ROL no permite agregar un OrderItem");
        }

        if(!user.getId().equals(super.getShoppingCart().getUser().getId())){
            throw  new Exception("ERROR: USUARIO DIFERENTE");
        }

        super.addOrderItem(shoppingCartItem);
    }

    @Override
    public void removerOrderItem(Integer idOrderItem) throws Exception {
        if(user.getRol().equals(Roles.GERENTE)){
            throw new Exception("Tu ROL no permite eliminar un OrderItem");
        }
        if(!user.getId().equals(super.getShoppingCart().getUser().getId())){
            throw  new Exception("ERROR: USUARIO DIFERENTE");
        }
        super.removerOrderItem(idOrderItem);
    }

    @Override
    public void deleteShopping() throws Exception {
        if(user.getRol().equals(Roles.GERENTE)){
            throw new Exception("Tu ROL no permite eliminar un ShoppingCart");
        }
        if(!user.getId().equals(super.getShoppingCart().getUser().getId())){
            throw  new Exception("ERROR: USUARIO DIFERENTE");
        }
        super.deleteShopping();
    }

    @Override
    public void addShoppingCart(User user, ShoppingCart shoppingCart) throws Exception {
        if(user.getRol().equals(Roles.GERENTE)){
            throw new Exception("Tu ROL no permite añadir un ShoppingCart al User");
        }
        if(!user.getId().equals(super.getShoppingCart().getUser().getId())){
            throw  new Exception("ERROR: USUARIO DIFERENTE");
        }

        user.getShoppingCart().add(shoppingCart);

    }

    @Override
    public void removeShoppingCart(User user, ShoppingCart shoppingCart) throws Exception {
        if(user.getRol().equals(Roles.GERENTE)){
            throw new Exception("Tu ROL no permite remover un ShoppingCart al User");
        }
        if(!user.getId().equals(super.getShoppingCart().getUser().getId())){
            throw  new Exception("ERROR: USUARIO DIFERENTE");
        }

    }

    @Override
    public ShoppingCart getShoppingCart() {
        return super.getShoppingCart();
    }

    public User getUser() {
        return user;
    }



}
