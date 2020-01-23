/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author programmer
 */
@Entity
@Table(name = "categories")
@Data
@ToString(exclude = {"produts"})
@JsonDeserialize(as = Category.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false, unique = true)
    @Length(min = 1, max = 255, message = "lenght min 1 max 255 characters")
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private List<Product> produts;
}
