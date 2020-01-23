/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
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
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "produts_buy_details")
@Data
@ToString(exclude = {"product"})
@JsonDeserialize(as = ProductBuyDetails.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductBuyDetails implements Serializable {

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

    @Column(name = "UNIT_BUY_PRICE")
    private float unitBuyPrice;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "buyDetails")
    @JsonIgnoreProperties("product")
    private Product product;

}
