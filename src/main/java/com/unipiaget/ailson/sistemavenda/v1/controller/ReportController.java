/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.services.ReportService;
import com.unipiaget.ailson.sistemavenda.services.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@RestController("ReportController")
@RequestMapping("v1/reports")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private SaleService ss;

    @Autowired
    private ReportService rs;

    @RequestMapping(value = "/delivery_order/sale/{id}", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<byte[]> deliveryOrderReport(@PathVariable("id") int id) {

        byte[] pdf = rs.generateDeliveryOrderReport();
        if (pdf != null) {
            return new ResponseEntity<>(pdf, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
