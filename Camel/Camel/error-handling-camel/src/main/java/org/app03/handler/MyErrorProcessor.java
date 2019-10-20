/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app03.handler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class MyErrorProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        Exception e = exchng.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);        
        System.out.println("Actual Exception Message "+e.getMessage());
        System.out.println("Actual Exception Message "+e.getClass());
        
        String failedEndpoint = (String) exchng.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndpoint);
        
        exchng.getIn().setBody("Exception happened in the route.");
    }

}
