/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.to.db;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {      
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new JmsReadRoute());
        ctx.start();

        ConsumerTemplate consumer = ctx.createConsumerTemplate();
        String res = consumer.receiveBody("direct:readQueue", String.class);
        System.out.println(res);
    }

}
