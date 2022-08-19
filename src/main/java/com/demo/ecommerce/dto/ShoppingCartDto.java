package com.demo.ecommerce.dto;

import com.demo.ecommerce.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ShoppingCartDto {

    public Integer id;
    public List<OrderItem> lstProduct;
    Double total;
}
