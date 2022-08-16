package com.demo.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="orderDetails")
public class OrderDetails {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "order_ID", nullable = false)
    private long orderId;

    @OneToMany(cascade=CascadeType.ALL)
    @Column(name = "product_Id", nullable = false)
    private long productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unitPrice", nullable = false)
    private long unirPrice;

    @Column(name = "totalPrice", nullable = false)
    private long totalPrice;


}
