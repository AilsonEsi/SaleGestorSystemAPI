/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Product;
import com.unipiaget.ailson.sistemavenda.services.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController("ProductController")
@RequestMapping("v1/products")
@CrossOrigin(origins = "**")
public class ProductController {

    @Autowired
    private ProductService ps;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<?> findAll() {

        return new ResponseEntity<>(ps.findAll(), HttpStatus.CREATED);
    }

    @PostMapping(value = {"/", ""})
    public ResponseEntity<?> create(@Valid @RequestBody(required = true) Product p) {

        ps.save(p);
        return new ResponseEntity<>("Product was created succesfully", HttpStatus.CREATED);
    }

}
