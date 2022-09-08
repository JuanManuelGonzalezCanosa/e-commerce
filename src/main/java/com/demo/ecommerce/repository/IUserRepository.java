package com.demo.ecommerce.repository;

import com.demo.ecommerce.entities.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("IUserRepository")
public interface IUserRepository extends JpaRepository<User, Integer> {
}
