/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.trycatch;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class MyExceptionProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        Object body = exchng.getIn().getBody();
        System.out.println("###############MyExceptionProcessor:"+body);
    }
    
}
