/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unipiaget.ailson.sistemavenda.models.User;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author programmer
 */
public class UserDetailsPrinciple implements UserDetails {

    private int id;

    private String name;

    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsPrinciple(int id, String name, String username,
            String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role
                -> new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserDetailsPrinciple(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
