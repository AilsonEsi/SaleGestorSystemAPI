/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.v1.controller;

import com.unipiaget.ailson.sistemavenda.models.Contact;
import com.unipiaget.ailson.sistemavenda.services.ContactService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author programmer
 */
@RestController("ContactController")
@RequestMapping("v1/contacts")
public class ContactController {

    @Autowired
    private ContactService cs;

    @GetMapping(value = {"/", ""}, produces = "application/json")
    public ResponseEntity<List<Contact>> findAll() {
        return new ResponseEntity(cs.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> create(@Valid @RequestBody Contact c) {
        return new ResponseEntity("Contact was created succesfully", HttpStatus.CREATED);
    }

    /*
    @GetMapping(value = {"/map", ""}, produces = "application/json")
    public ResponseEntity<List<Map<String, Object>>> findAllMap() {

        Map<String, Object> val = new HashMap<>();
        val.put("nome", "Ailson");
        val.put("idade", 23);
        val.put("sexo", "M");

        Map<String, Object> val2 = new HashMap<>();

        val2.put("nome", "Jose");
        val2.put("idade", 24);
        val2.put("sexo", "M");

        List<Map<String, Object>> o = new ArrayList();
        o.add(val);
        o.add(val2);

        return new ResponseEntity(o, HttpStatus.OK);
    }
     */
}
