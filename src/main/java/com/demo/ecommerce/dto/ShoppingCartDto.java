package com.demo.ecommerce.dto;

import com.demo.ecommerce.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartDto {

    public Integer id;
    public List<OrderItemDto> lstOrderItemDto;
    public double total;
}
