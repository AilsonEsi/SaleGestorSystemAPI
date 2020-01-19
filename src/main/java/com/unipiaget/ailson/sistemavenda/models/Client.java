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
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "clients", uniqueConstraints = @UniqueConstraint(columnNames = "bi"))
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME", nullable = false)
    @Length(min = 1, max = 255, message = "lenght min 1 max 255 characters")
    private String name;
    private Contact contact;
    @Column(name = "BI")
    private int bi;
    private List<Sale> sales;

}
