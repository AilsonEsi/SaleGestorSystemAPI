/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.services;

import com.unipiaget.ailson.sistemavenda.models.Category;
import com.unipiaget.ailson.sistemavenda.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository cr;

    public void save(Category c) {
        cr.save(c);
    }

    public List<Category> findAll() {
        return cr.findAll();
    }

    public boolean exist(String name) {
        Category c = cr.findByName(name).get();
        if (c != null) {
            return true;
        }

        return false;
    }
}
