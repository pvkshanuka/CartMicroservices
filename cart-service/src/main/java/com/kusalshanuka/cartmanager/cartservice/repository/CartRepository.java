package com.kusalshanuka.cartmanager.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kusalshanuka.cartmanager.cartservice.model.Cart;

@Component
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
