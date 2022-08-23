package com.demo.ecommerce.dto;

import com.demo.ecommerce.entities.OrderItem;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ShoppingCartDto {

    public Integer id;
    public List<OrderItemDto> lstOrderItemDto = new ArrayList<>();
    public double total;

    private TypeMap<OrderItem, OrderItemDto> orderToDto;
    private ModelMapper modelMapper = new ModelMapper();

    public ShoppingCartDto() {

        orderToDto = modelMapper.createTypeMap(OrderItem.class, OrderItemDto.class);
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getName(), OrderItemDto::setNameDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getDescription(), OrderItemDto::setDescriptionDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getPrice(), OrderItemDto::setPriceDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().getName(), OrderItemDto::setNameDto));
        orderToDto.addMappings(mapper -> mapper.map(orderItem -> orderItem.getItem().isPromotion(), OrderItemDto::setPromotionDto));
    }

    public void setLstOrderItemDto(List<OrderItem> list) {
        this.lstOrderItemDto = list.stream().map((orderItem -> {
            OrderItemDto orderItemDto = new OrderItemDto();
            modelMapper.map(orderItem, orderItemDto);
            return orderItemDto;
        })).collect(Collectors.toList());
    }
}
