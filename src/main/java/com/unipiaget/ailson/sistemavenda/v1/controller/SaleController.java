/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Sale;
import com.unipiaget.ailson.sistemavenda.services.SaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@RestController("SaleController")
@RequestMapping("v1/sales")
public class SaleController {

    @Autowired
    private SaleService ss;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Sale>> findAll() {
        return new ResponseEntity(ss.findAll(), HttpStatus.OK);
    }
}
