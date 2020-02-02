/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Client;
import com.unipiaget.ailson.sistemavenda.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author programmer
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository cr;

    @Transactional
    public void save(Client c) {
        cr.save(c);
    }

    public List<Client> findAll() {
        return cr.findAll();
    }

    public Client findById(int id) {

        Optional<Client> client = cr.findById(id);
        Client c = null;
        if (client.isPresent()) {
            c = client.get();
        }

        return c;
    }
}
