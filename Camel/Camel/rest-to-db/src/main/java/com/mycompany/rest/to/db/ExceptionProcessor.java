/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class ExceptionProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        System.out.println("Handler!!!!");
        Exception ex = exchng.getIn().getBody(Exception.class);
       // ex.printStackTrace();
    }

}
