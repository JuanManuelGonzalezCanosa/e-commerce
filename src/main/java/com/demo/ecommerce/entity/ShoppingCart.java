package com.demo.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="ShoppingCart")
public class ShoppingCart {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    @Column(name = "user_Id", nullable = false)
    private long userId;

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "product_Id", nullable = false)
    private List<Product> productId;

}
