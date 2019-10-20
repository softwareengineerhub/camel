/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.xslt.fromfile;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class AfterXsltProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("-----------AfterXsltProcessor START--------------");
        System.out.println(exchange.getIn().getBody());
        System.out.println("-----------AfterXsltProcessor END--------------");        
    }
    
}
