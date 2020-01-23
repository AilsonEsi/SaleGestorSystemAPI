/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Supplier;
import com.unipiaget.ailson.sistemavenda.services.SupplierService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@RestController("SupplierController")
@RequestMapping(value = "v1/suppliers")
@CrossOrigin(origins = "**")
public class SupplierController {

    @Autowired
    private SupplierService ss;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Supplier>> getAllSuppliers() {

        return new ResponseEntity(ss.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = {"/", ""})
    public ResponseEntity<?> create(@Valid @RequestBody(required = true) Supplier sup) {
        ss.save(sup);
        return new ResponseEntity("User was created successfully", HttpStatus.CREATED);
    }
    
}
