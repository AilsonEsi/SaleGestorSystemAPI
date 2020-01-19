/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.message.request.LoginForm;
import com.unipiaget.ailson.sistemavenda.message.response.JwtTokenResponse;
import com.unipiaget.ailson.sistemavenda.security.jwt.JwtTokenProvider;
import com.unipiaget.ailson.sistemavenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@CrossOrigin(origins = {"http://localhost:4200", "**"})
@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> authenticate(@RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateJwtToken(authentication);

        UserDetails ud = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<>(new JwtTokenResponse(token, ud.getUsername(), ud.getAuthorities()), HttpStatus.OK);

    }
}
