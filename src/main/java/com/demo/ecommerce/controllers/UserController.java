package com.demo.ecommerce.controllers;


import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    public UserService service;

    private RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return new ResponseEntity<User>(service.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<User> lstUser(){ return service.lstUser();}

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(service.getUserById(id));
        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putUserById(@RequestBody User user, @PathVariable Integer id){
        try {
            return new ResponseEntity<User>(service.putUserById(user, id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deteleUserById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.deleteUserById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addshoppingcart/iduser/{idUser}/idshoppingcart/{idShoppingCart}")
    public ResponseEntity<?> userAddShoppingCart(@PathVariable Integer idUser, @PathVariable Integer idShoppingCart) throws Exception {
        try {
            ResponseEntity<ShoppingCart> response = restTemplate.getForEntity("http://localhost:8080/shoppingcart/"+ idShoppingCart.toString(), ShoppingCart.class);
            ShoppingCart shoppingCart = response.getBody();
            return new ResponseEntity<User>(service.userAddShoppingCart(idUser, shoppingCart), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/removeshoppingcart/idUser/{idUser}/idShoppingCart/{idShoppingCart}")
    public ResponseEntity<?> removeShoppingCartToUser(@PathVariable Integer idUser, @PathVariable Integer idShoppingCart) throws Exception {
        try{
            ResponseEntity<ShoppingCart> responseShopping = restTemplate.getForEntity("http://localhost:8080/" + idShoppingCart.toString(), ShoppingCart.class);
            ShoppingCart shoppingCart = responseShopping.getBody();
            return new ResponseEntity<>(service.removeShoppingCartToUser(idUser, shoppingCart), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
