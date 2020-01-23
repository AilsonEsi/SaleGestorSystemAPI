/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Category;
import com.unipiaget.ailson.sistemavenda.services.CategoryService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@RestController("CategoryController")
@RequestMapping("v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService cs;

    @GetMapping(value = {"/", ""}, produces = "application/json")
    public ResponseEntity<?> findAll() {

        return new ResponseEntity(cs.findAll(), HttpStatus.CREATED);
    }

    @PostMapping(value = {"/", ""}, consumes = "application/json")
    public ResponseEntity<?> create(@Valid @RequestBody(required = true) Category c) {

        if (c.getName().equals("") || c == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        cs.save(c);
        return new ResponseEntity("Category was created successfully", HttpStatus.CREATED);
    }

}
