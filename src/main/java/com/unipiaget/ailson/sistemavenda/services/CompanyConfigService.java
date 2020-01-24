/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.CompanyConfig;
import com.unipiaget.ailson.sistemavenda.repositories.CompanyConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class CompanyConfigService {

    @Autowired
    private CompanyConfigRepository cr;

    public CompanyConfig findById() {
        return cr.findById(1).get();
    }

}
