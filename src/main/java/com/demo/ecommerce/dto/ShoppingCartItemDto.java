package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartItemDto {

    public Integer id;
    public String name;
    public String description;
    public double price;
    public int quantity;
    public boolean promotion;
}
