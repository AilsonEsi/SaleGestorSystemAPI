/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "code"}))
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "CODE", unique = true)
    @NumberFormat
    private int code;

    @Column(name = "NAME", nullable = false, unique = true)
    @UniqueElements(message = "name already exist in database")
    @Length(min = 1, max = 255, message = "lenght min 1 max 255 characters")
    private String name;

    private String description;

    private int qtyAvailabe;

    private float unitSalePrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_buy_details_id", referencedColumnName = "ID")
    private ProductBuyDetails productBuyDetails;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "ID")
    private Supplier supplier;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<Sale> sales;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buy_details_id", referencedColumnName = "ID")
    private ProductBuyDetails buydetails;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "ID")
    )
    private List<Category> categories;

}
