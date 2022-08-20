package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderItemDto {

    public Integer idProduct;
    public String name;
    public String description;
    public double price;
    public int quantity;
    public boolean promotion;

}
