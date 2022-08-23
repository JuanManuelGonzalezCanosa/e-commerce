package com.demo.ecommerce.controllers;

import com.demo.ecommerce.dto.ShoppingCartDto;
import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.services.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/createShoppingCart")
    public ShoppingCart createToCart(@RequestBody ShoppingCart shoppingCart){
        return service.createToCart(shoppingCart);
    }

    @GetMapping("/shoppingCart/all")
    public List<ShoppingCart> lstShoppingCart(){
        return service.lstShoppingCart();
    }

    @GetMapping("/shoppingCart/{id}")
    public ShoppingCart getShoppingCartById(@PathVariable Integer id){
        return service.getShoppingCartById(id);
    }

    @GetMapping("/shoppingCartDto/{id}")
    public ResponseEntity<ShoppingCartDto> getShoppingCartDtoById(@PathVariable Integer id){
        try{
            ShoppingCart shoppingCart = service.getShoppingCartById(id);
            ShoppingCartDto shoppingCartDto = new ShoppingCartDto();

            TypeMap<ShoppingCart, ShoppingCartDto> mapperShopping = modelMapper.createTypeMap(ShoppingCart.class, ShoppingCartDto.class);
            mapperShopping.addMappings(mapper -> mapper.map(ShoppingCart::getLstOrderItem, ShoppingCartDto::setLstOrderItemDto));

            modelMapper.map(shoppingCart, shoppingCartDto);

            return new ResponseEntity<ShoppingCartDto>(shoppingCartDto, HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<ShoppingCartDto>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/addProductToShoppingCart/{id}")
    public ShoppingCart addProductToShoppingCart(@RequestBody OrderItem orderItem, @PathVariable Integer id){

        try {
            return service.addProductToShoppingCart(orderItem, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



}
