/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.repositories;

import com.unipiaget.ailson.sistemavenda.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author programmer
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
