/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Employee;
import com.unipiaget.ailson.sistemavenda.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository er;

    public Employee findById(int id) {
        return er.findById(id).get();
    }
}
