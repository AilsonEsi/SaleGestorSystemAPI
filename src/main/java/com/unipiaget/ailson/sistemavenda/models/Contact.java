/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Data;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "contacts")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    @Email(message = "the email is invalid, please enter the valid email")
    private String email;

    @OneToOne(mappedBy = "contact")
    private Client client;

    @OneToOne(mappedBy = "contact")
    private Employee employee;

    @OneToOne(mappedBy = "contact")
    private Supplier supplier;

}
