/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import lombok.Data;

/**
 *
 * @author programmer
 */
@Data
public abstract class Person {

    private int id;
    private String name;
    private Contact contact;

    public Person(int id, String name, Contact contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

   

}
