package com.demo.ecommerce.repository;

import com.demo.ecommerce.dto.ShoppingCartDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("IShoppingCartDtoRepository")
public interface IShoppingCartDtoRepository extends JpaRepository<ShoppingCartDto, Integer> {

}
