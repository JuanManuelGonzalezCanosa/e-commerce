package com.demo.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @OneToOne
    @JoinColumn(name = "FK_ROLES", updatable = false, nullable = false)
    private Roles rol;

    @OneToOne
    @JoinColumn(name = "FK_SHOOPING_CART_ITEM", updatable = false, nullable = false)
    private ShoppingCart shoppingCart;
}
