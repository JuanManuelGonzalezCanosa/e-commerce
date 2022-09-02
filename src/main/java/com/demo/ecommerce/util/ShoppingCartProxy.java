package com.demo.ecommerce.util;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.exceptions.ErrorOrderItemIsNotEnabled;
import com.demo.ecommerce.exceptions.ErrorQuantityProductNegative;
import com.demo.ecommerce.exceptions.ShoppingCartFull;
import com.demo.ecommerce.exceptions.StockEception;
import com.demo.ecommerce.services.OrderItemService;

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
            orderItem.getItem().setPrice(this.shoppingCart.getTotal() + (0.90 * ((orderItem.getItem().getPrice() *orderItem.getQuantity()))));
        }

        this.shoppingCart.getLstOrderItem().add(orderItem);
        this.shoppingCart.setTotal(this.shoppingCart.getTotal() + (orderItem.getItem().getPrice() *orderItem.getQuantity()));

    }


    @Override
    public void removerOrderItem(Integer idOrderItem) throws Exception{

        OrderItem orderItem = this.shoppingCart.getLstOrderItem().get(idOrderItem);
        this.shoppingCart.getLstOrderItem().removeIf((orderItem_ -> orderItem_.equals(orderItem)));

        this.shoppingCart.setTotal(this.shoppingCart.getTotal() - (orderItem.getItem().getPrice() *orderItem.getQuantity()));
    }

    public void removeShopping(ShoppingCart shoppingCart)throws Exception{

        if(!shoppingCart.getLstOrderItem().isEmpty()){
            throw new ShoppingCartFull();
        }

    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
