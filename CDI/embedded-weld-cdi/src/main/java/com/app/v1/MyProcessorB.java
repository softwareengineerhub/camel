/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.v1;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;

/**
 *
 * @author dprokopiuk
 */
@Any
@Default
public class MyProcessorB implements MyProcessor {

    @Override
    public void process() {
        System.out.println("MyProcessorB");
    }
    
}
