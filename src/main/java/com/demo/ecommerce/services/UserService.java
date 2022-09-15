package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.entities.User;
import com.demo.ecommerce.repository.IUserRepository;
import com.demo.ecommerce.util.ShoppingCartProxy;
import com.demo.ecommerce.util.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("UserService")
public class UserService {

    @Autowired
    @Qualifier("IUserRepository")
    private IUserRepository repository;

    public User createUser(User user) {return repository.save(user);}

    public List<User> lstUser() {
        return repository.findAll();
    }

    public User getUserById(Integer id) {
        return repository.findById(id).get();
    }


    public boolean putUserById(User user, Integer id) {

        User aux = this.getUserById(id);

        aux.setName(user.getName());
        aux.setPassword(user.getPassword());
        aux.setRol(user.getRol());
        aux.setShoppingCart(user.getShoppingCart());
        aux.setActive(user.isActive());

        repository.save(aux);
        return  true;
    }

    public boolean deleteUserById(Integer id){


        repository.deleteById(id);
        return true;
    }

    public User userAddShoppingCart(Integer idUser, ShoppingCart shoppingCart) throws Exception {
        User user = this.getUserById(idUser);
        UserProxy userProxy = new UserProxy(user, shoppingCart);

        userProxy.addShoppingCart(user, shoppingCart);

        return repository.save(userProxy.getUser());
    }

    public boolean removeShoppingCartToUser(Integer idUser, ShoppingCart shoppingCart) throws Exception {
        User user = this.getUserById(idUser);
        UserProxy userProxy = new UserProxy(user, shoppingCart);

        userProxy.removeShoppingCart(user, shoppingCart);

        user.getShoppingCart().remove(shoppingCart);

        repository.save(user);

        return true;
    }


}
