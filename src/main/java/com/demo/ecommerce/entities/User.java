package com.demo.ecommerce.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@Column(name = "roles")
    //private Roles roles;


    @OneToOne
    @JoinColumn(name = "shoppingCartItem", updatable = false, nullable = false)
    private ShoppingCartItem shoppingCartItem;

}
