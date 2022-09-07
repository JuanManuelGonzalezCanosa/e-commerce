package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.exceptions.ErrorOrderItemIsNotEnabled;
import com.demo.ecommerce.exceptions.ErrorQuantityProductNegative;
import com.demo.ecommerce.exceptions.ShoppingCartFull;
import com.demo.ecommerce.exceptions.StockEception;

public class ShoppingCartProxy implements IShoppingCart {
    private final ShoppingCart shoppingCart;

    public ShoppingCartProxy (ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addOrderItem(ShoppingCartItem shoppingCartItem) throws Exception {

        // CANTIDAD DE PRODUCTOS NEGATIVA
        if (shoppingCartItem.getQuantity() < 0) {
            throw new ErrorQuantityProductNegative();
        }

        //EL PRODUCTO NO ESTA HABILITADO
        if (!shoppingCartItem.getItem().isEnabled()) {
            throw new ErrorOrderItemIsNotEnabled();
        }

        //NO HAY STOCK
        if (shoppingCartItem.getItem().getStock() < shoppingCartItem.getQuantity()) {
            throw new StockEception();
        }
            //TIENE DESCUENTO?
        if (shoppingCartItem.getItem().isPromotion()) {
            shoppingCartItem.getItem().setPrice(this.shoppingCart.getTotal() + (0.90 * ((shoppingCartItem.getItem().getPrice() * shoppingCartItem.getQuantity()))));
        }

        this.shoppingCart.getLstShoppingCartItem().add(shoppingCartItem);
        this.shoppingCart.setTotal(this.shoppingCart.getTotal() + (shoppingCartItem.getItem().getPrice() * shoppingCartItem.getQuantity()));

    }


    @Override
    public void removerOrderItem(Integer idOrderItem) throws Exception{

        ShoppingCartItem shoppingCartItem = this.shoppingCart.getLstShoppingCartItem().get(idOrderItem);
        this.shoppingCart.getLstShoppingCartItem().removeIf((orderItem_ -> orderItem_.equals(shoppingCartItem)));

        this.shoppingCart.setTotal(this.shoppingCart.getTotal() - (shoppingCartItem.getItem().getPrice() * shoppingCartItem.getQuantity()));
    }

    public void removeShopping(ShoppingCart shoppingCart)throws Exception{

        if(!shoppingCart.getLstShoppingCartItem().isEmpty()){
            throw new ShoppingCartFull();
        }

    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
