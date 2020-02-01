/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Product;
import com.unipiaget.ailson.sistemavenda.models.ProductQty;
import com.unipiaget.ailson.sistemavenda.models.Sale;
import com.unipiaget.ailson.sistemavenda.models.SaleProductsDetails;
import com.unipiaget.ailson.sistemavenda.models.SaleRequest;
import com.unipiaget.ailson.sistemavenda.services.EmployeeService;
import com.unipiaget.ailson.sistemavenda.services.ProductService;
import com.unipiaget.ailson.sistemavenda.services.SaleService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@RestController
@RequestMapping("/v1/sale")
public class SaleTestController {

    @Autowired
    private SaleService ss;

    @Autowired
    private ProductService ps;

    @Autowired
    private EmployeeService es;

    @PostMapping(value = {"/", ""})
    public ResponseEntity<?> create(@Valid @RequestBody SaleRequest sr) {

        Sale sale = new Sale();
        sale.setClient(sr.getC());
        //sale.setEmployee(es.findById(sr.getEmpId()));
        sale.setSaleDate(new Date());

        List<SaleProductsDetails> detailses = new ArrayList<>();

        for (ProductQty pq : sr.getPq()) {
            SaleProductsDetails s = new SaleProductsDetails();
            s.setProduct(ps.findById(pq.getProductId()));
            s.setQty(pq.getQty());
            s.setSale(sale);
            detailses.add(s);
            s.getProduct().setSaleProductsDetails(detailses);
        }

        //sale.getClient().getSales().add(sale);
        //sale.getEmployee().getSales().add(sale);
        sale.setSaleProductsDetails(detailses);
        //ss.save(sale);

        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<Sale>> findAll() {
        return new ResponseEntity(ss.findAll(), HttpStatus.OK);
    }
}
