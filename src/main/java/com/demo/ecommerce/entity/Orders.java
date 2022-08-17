package com.demo.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name="Orders")
public class Orders {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @Column(name = "user_Id", nullable = false)
    private long userId;

    @Column(name = "productsCount", nullable = false)
    private int productsCount;

    @Column(name = "priceDiscount", nullable = false)
    private long priceDiscount;

    @Column(name = "priceTax", nullable = false)
    private long priceTax;

    @Column(name = "totalPrice", nullable = false)
    private long totalPrice;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "orderBuyDate", nullable = false)
    private LocalDate orderBuyDate;

}
