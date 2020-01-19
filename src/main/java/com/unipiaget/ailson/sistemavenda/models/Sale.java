/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "sales")
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float saleTotal;
    private Employee employee;
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date saleDate;
    private List<Product> products;
    private Sale empployee;
    private Client client;

}
