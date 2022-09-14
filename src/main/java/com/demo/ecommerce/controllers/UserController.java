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

@RequestMapping("/User")
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
    public User getUserById(@PathVariable Integer id){
        return service.getUserById(id);
    }

    @PutMapping("/put/{id}")
    public boolean putUserById(@RequestBody User user, @PathVariable Integer id){
        return service.putUserById(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deteleUserById(@PathVariable Integer id){
        return service.deleteUserById(id);
    }

    @PostMapping
    public User userAddShoppingCart(@PathVariable Integer idUser, @PathVariable Integer idShoppingCart) throws Exception {
        ResponseEntity<ShoppingCart> response = restTemplate.getForEntity("http://localhost:8080/shoppingCart/"+ idShoppingCart.toString(), ShoppingCart.class);
        ShoppingCart shoppingCart = response.getBody();

        return service.userAddShoppingCart(idUser, shoppingCart);
    }


}
