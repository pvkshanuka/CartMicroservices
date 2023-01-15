package com.kusalshanuka.cartmanager.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kusalshanuka.cartmanager.authservice.model.User;

//import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {


    Optional<User> findByUsername(String name);

}
