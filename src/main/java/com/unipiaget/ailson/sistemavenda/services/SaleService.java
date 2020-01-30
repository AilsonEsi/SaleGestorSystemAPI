/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Sale;
import com.unipiaget.ailson.sistemavenda.models.SaleProductsDetails;
import com.unipiaget.ailson.sistemavenda.repositories.SaleRepository;
import com.unipiaget.ailson.sistemavenda.utils.Calculator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class SaleService {

    @Autowired
    private SaleRepository sr;

    public void save(Sale s) {

        Sale newSale = Calculator.calculate(s);
        sr.save(newSale);
    }

    public List<Sale> findAll() {
        return sr.findAll();
    }

    public Sale findById(int id) {
        return sr.getOne(id);
    }

    public Sale findLastSale() {
        return sr.findLastSale();
    }
}
