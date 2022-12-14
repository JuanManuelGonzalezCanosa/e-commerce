package com.demo.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="OrderDetails")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "orderId", nullable = false)
    private List<Orders> orders;

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "productId", nullable = false)
    private List<Orders> prodcutos;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unitPrice", nullable = false)
    private long unitPrice;

    @Column(name = "totalPrice", nullable = false)
    private long totalPrice;


}
