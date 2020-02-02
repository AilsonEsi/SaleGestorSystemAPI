/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Client;
import com.unipiaget.ailson.sistemavenda.models.Employee;
import com.unipiaget.ailson.sistemavenda.models.Product;
import com.unipiaget.ailson.sistemavenda.models.ProductQty;
import com.unipiaget.ailson.sistemavenda.models.Sale;
import com.unipiaget.ailson.sistemavenda.models.SaleProductsDetails;
import com.unipiaget.ailson.sistemavenda.models.SaleRequest;
import com.unipiaget.ailson.sistemavenda.services.ClientService;
import com.unipiaget.ailson.sistemavenda.services.EmployeeService;
import com.unipiaget.ailson.sistemavenda.services.ProductService;
import com.unipiaget.ailson.sistemavenda.services.SaleService;
import com.unipiaget.ailson.sistemavenda.utils.Calculator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RestController
@RequestMapping("/v1/sale")
@Slf4j
public class SaleTestController {

    @Autowired
    private SaleService ss;

    @Autowired
    private ProductService ps;

    @Autowired
    private EmployeeService es;

    @Autowired
    private ClientService cs;

    @PostMapping(value = {"/", ""})
    public ResponseEntity<?> create(@Valid @RequestBody SaleRequest sr) {

        Client c = cs.findById(sr.getClientId());
        Employee emp = es.findById(sr.getEmployeeId());

        Sale sale = new Sale();
        sale.setClient(c);
        sale.setEmployee(emp);
        log.info(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()).toString());

        sale.setSaleDate(new Date(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date())));

        List<SaleProductsDetails> detailses = new ArrayList<>();

        //associate products to one sale
        for (ProductQty pq : sr.getProductQuantity()) {
            SaleProductsDetails sp = new SaleProductsDetails();
            sp.setProduct(ps.findById(pq.getProductId()));
            sp.setQty(pq.getQty());
            sp.setSale(sale);
            detailses.add(sp);
            sp.getProduct().setSaleProductsDetails(detailses);
        }

        c.getSales().add(sale);
        emp.getSales().add(sale);
        sale.setSaleProductsDetails(detailses);
        ss.save(sale);
        
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Sale>> findAll() {
        return new ResponseEntity(ss.findAll(), HttpStatus.OK);
    }
}
