/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Supplier;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@RestController("SupplierController")
@RequestMapping(value = "v1/supplier")
public class SupplierController {
    
    

    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        
        return new ResponseEntity(HttpStatus.OK);
    }
}
