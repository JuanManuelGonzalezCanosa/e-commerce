package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderItemDto {

    public Integer id;
    public String name;
    public String description;
    public double price;
    public boolean promotion;

}
