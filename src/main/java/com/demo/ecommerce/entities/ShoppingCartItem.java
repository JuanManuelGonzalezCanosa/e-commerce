package com.demo.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "OrderItem")
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Integer idOrderItem;

    @OneToOne
    @MapsId
    private Product item;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartItem)) return false;
        ShoppingCartItem shoppingCartItem = (ShoppingCartItem) o;
        return quantity == shoppingCartItem.quantity && Objects.equals(idOrderItem, shoppingCartItem.idOrderItem) && Objects.equals(item, shoppingCartItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderItem, item, quantity);
    }


}