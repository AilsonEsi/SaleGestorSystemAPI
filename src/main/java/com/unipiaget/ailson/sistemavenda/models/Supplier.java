/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "suppliers")
@Data
@ToString(exclude = {"products","contact"})
@JsonDeserialize(as = Supplier.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    @Length(min = 1, max = 255, message = "lenght min 1 max 255 characters")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("supplier")
    private Contact contact;
}
