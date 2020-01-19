/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "produts_buy_details")
@Data
public class ProductBuyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BUY_DATE")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date buyDate;

    @Column(name = "QTY")
    @NumberFormat
    private int qty;

    @Column(name = "TOTAL")
    @NumberFormat
    private float total;

    @Column(name = "OBS")
    private String obs;

    @Column(name = "UNIT_SALE_PRICE")
    private float unitSalePrice;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productBuyDetails")
    private Product product;

}
