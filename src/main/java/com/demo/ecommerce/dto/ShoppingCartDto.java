package com.demo.ecommerce.dto;

import com.demo.ecommerce.entities.ShoppingCartItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ShoppingCartDto {

    public Integer id;
    public List<ShoppingCartItemDto> lstShoppingCartItemDto = new ArrayList<>();
    public double total;

    private TypeMap<ShoppingCartItem, ShoppingCartItemDto> orderToDto;
    private ModelMapper modelMapper = new ModelMapper();

    public ShoppingCartDto() {

        orderToDto = modelMapper.createTypeMap(ShoppingCartItem.class, ShoppingCartItemDto.class);
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getName(), ShoppingCartItemDto::setNameDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getDescription(), ShoppingCartItemDto::setDescriptionDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getPrice(), ShoppingCartItemDto::setPriceDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().isPromotion(), ShoppingCartItemDto::setPromotionDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getId(), ShoppingCartItemDto::setIdProductDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getQuantity(), ShoppingCartItemDto::setQuantityDto));
    }

    public void setLstOrderItemDto(List<ShoppingCartItem> list) {
        this.lstShoppingCartItemDto = list.stream().map((orderItem -> {
            ShoppingCartItemDto shoppingCartItemDto = new ShoppingCartItemDto();
            modelMapper.map(orderItem, shoppingCartItemDto);
            return shoppingCartItemDto;
        })).collect(Collectors.toList());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @JsonProperty("items")
    public List<ShoppingCartItemDto> getLstOrderItemDto() {
        return lstShoppingCartItemDto;
    }
}
