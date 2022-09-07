package com.demo.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartItemDto {

    public Integer idProductDto;

    public String nameDto;

    public String descriptionDto;

    public double priceDto;

    public int quantityDto;

    public boolean promotionDto;

}
