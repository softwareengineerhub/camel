/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch04.grouped.exchange;

import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class MyExchangeProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        Object body=exchng.getIn().getBody();
        System.out.println("body: "+body);
        Object property=exchng.getProperty(Exchange.GROUPED_EXCHANGE);        
        System.out.println("property: "+property);
        if(body instanceof List){
            List<Exchange> list = (List<Exchange>) body;
            for(Exchange item: list){
                System.out.println("--------------------"+item.getIn().getBody());                
            }
        }                
        
    }
    
}
