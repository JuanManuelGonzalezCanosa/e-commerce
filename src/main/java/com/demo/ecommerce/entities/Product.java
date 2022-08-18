package com.demo.ecommerce.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "photoURL", nullable = false)
    private String photoURL;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

    @Column(name = "isPromotion", nullable = false)
    private boolean isPromotion;



}
