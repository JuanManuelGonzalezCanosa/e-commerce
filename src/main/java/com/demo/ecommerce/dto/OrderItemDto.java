package com.demo.ecommerce.dto;

import com.demo.ecommerce.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDto {

    public Integer idProductDto;

    public String nameDto;

    public String descriptionDto;

    public double priceDto;

    public int quantityDto;

    public boolean promotionDto;

}
