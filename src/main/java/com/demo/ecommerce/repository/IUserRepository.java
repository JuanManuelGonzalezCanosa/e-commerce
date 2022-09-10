package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
