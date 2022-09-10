package com.demo.ecommerce.services;


import com.demo.ecommerce.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    @Qualifier("IUserRepository")
    private IUserRepository repository;
}
