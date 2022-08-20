package com.demo.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="ShoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idShoppingCart;

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "lstProduct", nullable = true)
    private List<OrderItem> lstOrderItem;

    @Column(name = "total", nullable = true)
    private Double total;

    @Column(name = "status", nullable = true)
    private boolean status;



}
