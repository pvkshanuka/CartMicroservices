package com.kusalshanuka.cartmanager.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kusalshanuka.cartmanager.authservice.model.AuthUserDetail;
import com.kusalshanuka.cartmanager.authservice.model.User;
import com.kusalshanuka.cartmanager.authservice.repository.UserDetailRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<User> optionalUser = userDetailRepository.findByUsername(name);

        System.out.println("User - "+optionalUser.get().getEmail());
        
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

        System.out.println("User - "+optionalUser.get().getEmail());
        System.out.println("PWD - "+optionalUser.get().getPassword());

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;


    }
}
