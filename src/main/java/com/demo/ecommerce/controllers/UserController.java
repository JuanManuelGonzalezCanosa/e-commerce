package com.demo.ecommerce.controllers;



import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody User user) {
        return new ResponseEntity<User>(service.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<User> lstUser(){
        return service.lstUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return service.getUserById(id);
    }

    @PutMapping("/put/{id}")
    public boolean putUserById(@RequestBody User user, @PathVariable Integer id){
        return service.putUserById(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteuserById(@PathVariable Integer id){
        return service.deleteUserById(id);
    }

}
