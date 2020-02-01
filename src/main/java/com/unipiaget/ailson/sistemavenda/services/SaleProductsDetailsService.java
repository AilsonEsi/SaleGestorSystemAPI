/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.SaleProductsDetails;
import com.unipiaget.ailson.sistemavenda.repositories.SaleProductsDetailsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class SaleProductsDetailsService {

    @Autowired
    private SaleProductsDetailsRepository spdr;

    public void save(SaleProductsDetails spd) {
        spdr.save(spd);
    }

    public List<SaleProductsDetails> findAll() {
        return spdr.findAll();
    }

}
