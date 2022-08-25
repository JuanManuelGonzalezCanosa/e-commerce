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
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Integer idProduct;

    @OneToOne
    @MapsId
    private Product item;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Objects.equals(idProduct, orderItem.idProduct) && Objects.equals(item, orderItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, item, quantity);
    }
}
