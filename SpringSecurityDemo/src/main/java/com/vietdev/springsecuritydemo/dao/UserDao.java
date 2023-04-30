package com.vietdev.springsecuritydemo.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author VietDev
 * @date 01/05/2023
 * @role
 */

@Repository
public class UserDao {
    private final List<UserDetails> userDetailsList = Arrays.asList(
            new User("vietdev@gmail.com", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("hienthuc@gmail.com", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
    );

    public UserDetails findUserByEmail(String email){
        return userDetailsList.stream().filter(u -> u.getUsername().equals(email)).findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}

