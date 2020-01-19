/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Supplier;
import com.unipiaget.ailson.sistemavenda.repositories.SupplierRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author programmer
 */
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository sr;

    @Transactional
    public void save(Supplier s) {
        sr.save(s);
    }

    public List<Supplier> findAll() {
        return sr.findAll();
    }

}
