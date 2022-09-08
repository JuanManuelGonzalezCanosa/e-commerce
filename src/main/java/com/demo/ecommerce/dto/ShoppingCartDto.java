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
    @JsonProperty("items")
    public List<ShoppingCartItemDto> lstShoppingCartItemDto = new ArrayList<>();
    public double total;

    private TypeMap<ShoppingCartItem, ShoppingCartItemDto> orderToDto;
    private ModelMapper modelMapper = new ModelMapper();

    public ShoppingCartDto() {

        orderToDto = modelMapper.createTypeMap(ShoppingCartItem.class, ShoppingCartItemDto.class);
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getName(), ShoppingCartItemDto::setName));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getDescription(), ShoppingCartItemDto::setDescription));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getPrice(), ShoppingCartItemDto::setPrice));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().isPromotion(), ShoppingCartItemDto::setPromotion));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getId(), ShoppingCartItemDto::setId));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getQuantity(), ShoppingCartItemDto::setQuantity));
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

    public Integer getId() {
        return id;
    }

    public List<ShoppingCartItemDto> getLstShoppingCartItemDto() {
        return lstShoppingCartItemDto;
    }

    public double getTotal() {
        return total;
    }
}
