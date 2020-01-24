/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.utils;

import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class Calculator {

    public static float calculate(float value, int qty) {
        return value * qty;
    }
}
