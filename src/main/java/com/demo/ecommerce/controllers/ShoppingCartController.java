package com.demo.ecommerce.controllers;

import com.demo.ecommerce.dto.ShoppingCartDto;
import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.ShoppingCartItem;
import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.services.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private RestTemplate restTemplate;

    @Autowired
    private ShoppingCartService service;


    @Autowired
    public ShoppingCartController(RestTemplateBuilder restTemplateBuilder) {this.restTemplate = restTemplateBuilder.build();}

    @PostMapping("/create")
    public ResponseEntity<?> createToCart(@RequestBody ShoppingCart shoppingCart, @RequestHeader Integer Authorization)throws Exception{
        try{
            ResponseEntity<User> userAux = restTemplate.getForEntity("http://localhost:8080/user/" + Authorization.toString(), User.class);
            User user = userAux.getBody();

            return new ResponseEntity<ShoppingCart>(service.createToCart(shoppingCart, user), HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }

    }

    @GetMapping("/all")
    public List<ShoppingCart> lstShoppingCart(){
        return service.lstShoppingCart();
    }

    @GetMapping("/{id}")
    public ShoppingCart getShoppingCartById(@PathVariable Integer id){
        return service.getShoppingCartById(id);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ShoppingCartDto> getShoppingCartDtoById(@PathVariable Integer id){
        try{
            ShoppingCart shoppingCart = service.getShoppingCartById(id);
            ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
            ModelMapper modelMapper = new ModelMapper();
            TypeMap<ShoppingCart, ShoppingCartDto> mapperShopping = modelMapper.createTypeMap(ShoppingCart.class, ShoppingCartDto.class);
            mapperShopping.addMappings(mapper -> mapper.map(ShoppingCart::getLstShoppingCartItem, ShoppingCartDto::setLstOrderItemDto));
            mapperShopping.addMappings(mapper -> mapper.map(ShoppingCart::getTotal, ShoppingCartDto::setTotal));
            mapperShopping.addMappings(mapper -> mapper.map(ShoppingCart::getIdShoppingCart, ShoppingCartDto::setId));

            modelMapper.map(shoppingCart, shoppingCartDto);

            return new ResponseEntity<ShoppingCartDto>(shoppingCartDto, HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<ShoppingCartDto>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/add/shoppingcartitemid/{shoppingCartItemId}/id/{id}")
    public ShoppingCart addProductToShoppingCart(@RequestHeader Integer Authorization, @PathVariable Integer shoppingCartItemId, @PathVariable Integer id) {

        try {
            ResponseEntity<User> aux = restTemplate.getForEntity("http://localhost:8080/user/" + Authorization.toString(), User.class);
            User user = aux.getBody();

            ResponseEntity<ShoppingCartItem> auxShopping = restTemplate.getForEntity("http://localhost:8080/shoppingcartitem/" + shoppingCartItemId.toString(), ShoppingCartItem.class);
            ShoppingCartItem shoppingCartItem = auxShopping.getBody();

            return service.addProductToShoppingCart(user, shoppingCartItem, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    /*
        @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
        // code that uses the language variable
        return new ResponseEntity<String>(greeting, HttpStatus.OK);
    }
     */

    @DeleteMapping("/remove/shoppingid/{idShopoingcart}/itemid/{idOrderItem}")
    public ShoppingCart removeShoppingCartItem(@PathVariable Integer idShopoingCart, @PathVariable Integer idOrderItem) throws Exception {

        restTemplate.delete("http://localhost:8080/orderitem/" + idOrderItem.toString());

        return service.outProductByCarritoShopping(idShopoingCart, idOrderItem);
    }

    @PutMapping("/buy/{idShoppingCart}")
    public ResponseEntity<?> buy(@PathVariable Integer idShoppingCart)throws Exception{

        try{
            ShoppingCart shoppingCart = service.buy(idShoppingCart, restTemplate);

            return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }


    }

}
