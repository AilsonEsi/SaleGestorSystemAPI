/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.message.response;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author programmer
 */
@AllArgsConstructor
@Data
public class JwtTokenResponse {

    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

}
