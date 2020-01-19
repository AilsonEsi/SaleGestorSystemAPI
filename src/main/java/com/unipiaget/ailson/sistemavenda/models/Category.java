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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "categories",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "NAME", nullable = false, unique = true)
    @UniqueElements(message = "name already exist in database")
    @Length(min = 1, max = 255, message = "lenght min 1 max 255 characters")
    private String name;
    
    @ManyToMany(mappedBy = "categories")
    private List<Product> produts;
}
