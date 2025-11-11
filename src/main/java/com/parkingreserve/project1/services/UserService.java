package com.parkingreserve.project1.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.parkingreserve.project1.model.UserApp;
import com.parkingreserve.project1.repository.UserData;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserData repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserApp> user = repository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
         }else{
            throw new UsernameNotFoundException(username);
        }
    }
}
