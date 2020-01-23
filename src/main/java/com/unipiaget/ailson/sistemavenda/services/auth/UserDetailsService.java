/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services.auth;

import com.unipiaget.ailson.sistemavenda.models.User;
import com.unipiaget.ailson.sistemavenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author programmer
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String string) {
        
        User user = userRepository.findByUsername(string).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username" + string));
        
        return UserDetailsPrinciple.build(user);
    }
    
}
