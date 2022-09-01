package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.exceptions.ErrorOrderItemIsNotEnabled;
import com.demo.ecommerce.exceptions.ErrorQuantityProductNegative;
import com.demo.ecommerce.exceptions.StockEception;

public class ShoppingCartProxy implements IShoppingCart {
    private final ShoppingCart shoppingCart;
    public ShoppingCartProxy (ShoppingCart shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addOrderItem(OrderItem orderItem) throws Exception {

        // CANTIDAD DE PRODUCTOS NEGATIVA
        if (orderItem.getQuantity() < 0) {
            throw new ErrorQuantityProductNegative();
        }

        //EL PRODUCTO NO ESTA HABILITADO
        if (!orderItem.getItem().isEnabled()) {
            throw new ErrorOrderItemIsNotEnabled();
        }

        //NO HAY STOCK
        if (orderItem.getItem().getStock() < orderItem.getQuantity()) {
            throw new StockEception();
        }
            //TIENE DESCUENTO?
        if (orderItem.getItem().isPromotion()) {
            orderItem.getItem().setPrice(0.90 * orderItem.getItem().getPrice());
        }

        this.shoppingCart.getLstOrderItem().add(orderItem);
        this.shoppingCart.setTotal(this.shoppingCart.getTotal() + (orderItem.getItem().getPrice() *orderItem.getQuantity()));

    }


    @Override
    public void removerOrderItem(Integer idOrderItem) throws Exception{
        // filter listOrderitem x id y recuperallo
        OrderItem orderItem = ;
        this.shoppingCart.getLstOrderItem().removeIf((orderItem_ -> orderItem_.getIdOrderItem().equals(orderItem)));

        this.shoppingCart.setTotal(this.shoppingCart.getTotal() - (orderItem.getItem().getPrice() *orderItem.getQuantity()));
    }

    public boolean removeShopping(){
        // podes borra el carrito si no hay orderiTems presente
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
