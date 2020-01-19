/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.repositories;

import com.unipiaget.ailson.sistemavenda.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author programmer
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
