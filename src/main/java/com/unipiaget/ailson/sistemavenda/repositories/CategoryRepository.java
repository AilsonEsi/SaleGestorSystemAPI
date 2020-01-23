/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.repositories;

import com.unipiaget.ailson.sistemavenda.models.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author programmer
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category>findByName(String name);
}
