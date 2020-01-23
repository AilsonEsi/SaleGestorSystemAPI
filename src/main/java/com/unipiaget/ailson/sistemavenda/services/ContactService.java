/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Contact;
import com.unipiaget.ailson.sistemavenda.repositories.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository cr;

    public List<Contact> findAll() {
        return cr.findAll();
    }

    public void save(Contact c) {
        cr.save(c);
    }
}
