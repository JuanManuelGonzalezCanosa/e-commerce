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
    private double price;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "promotion", nullable = false)
    private boolean promotion;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return stock == product.stock && Double.compare(product.price, price) == 0 && enabled == product.enabled && promotion == product.promotion && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(photoURL, product.photoURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, stock, photoURL, price, enabled, promotion);
    }
}
