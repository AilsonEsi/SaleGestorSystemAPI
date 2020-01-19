/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME", nullable = false)
    @UniqueElements(message = "create valid product")
    @Length(min = 1, max = 255, message = "lenght min 1 max 255 characters")
    private String name;
    private String description;
    private int qtyAvailabe;
    private float unitSalePrice;
    private List<Category> categories;
    private ProductBuyDetails productBuyDetails;
    private Supplier supplier;
    private List<Sale> sales;
    private ProductBuyDetails buydetails;

}
