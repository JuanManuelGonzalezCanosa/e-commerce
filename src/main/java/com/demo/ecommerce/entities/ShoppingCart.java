package com.demo.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="ShoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idShoppingCart;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "lstProduct", nullable = true)
    private List<ShoppingCartItem> lstShoppingCartItem;

    @Column(name = "total", nullable = true)
    private Double total;

    @Column(name = "status", nullable = true)
    private boolean status;

    @OneToOne
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return status == that.status && Objects.equals(idShoppingCart, that.idShoppingCart) && Objects.equals(lstShoppingCartItem, that.lstShoppingCartItem) && Objects.equals(total, that.total) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShoppingCart, lstShoppingCartItem, total, status, user);
    }
}
