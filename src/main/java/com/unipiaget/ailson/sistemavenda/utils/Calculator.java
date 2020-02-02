/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.utils;

import com.unipiaget.ailson.sistemavenda.models.Sale;
import com.unipiaget.ailson.sistemavenda.models.SaleProductsDetails;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author programmer
 */
@Service
public class Calculator {

    private static Logger l = Logger.getLogger(Calculator.class);
    
    public static float calculate(float value, int qty) {
        return value * qty;
    }

    public static Sale calculate(Sale s) {
        float total = 0F;

        for (SaleProductsDetails data : s.getSaleProductsDetails()) {
            total += (data.getProduct().getUnitSalePrice() * data.getQty());
        }
        
        l.info(total);
        s.setSaleTotal(total);
        return s;
    }
}
