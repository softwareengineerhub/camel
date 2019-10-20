/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch03.enterpice.integration.patterns.recipient.list;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class RecipientProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String employeeType = exchng.getIn().getHeader("type", String.class);
        if("senior".equals(employeeType)){
            exchng.getIn().setHeader("type", "file:xmlsenior");
        }else{
            exchng.getIn().setHeader("type", "file:xmljunior");
        }
    }
    
}
