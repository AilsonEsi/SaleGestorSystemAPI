/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unipiaget.ailson.sistemavenda.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author programmer
 */
@Data
public class SaleRequest {

    private List<ProductQty> productQuantity = new ArrayList<>();
    private int employeeId;
    private int clientId;

}
