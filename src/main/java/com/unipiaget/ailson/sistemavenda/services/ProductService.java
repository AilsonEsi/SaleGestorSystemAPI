/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Product;
import com.unipiaget.ailson.sistemavenda.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    public void save(Product p) {
        pr.save(p);
    }

    public List<Product> findAll() {
        return pr.findAll();
    }
}
