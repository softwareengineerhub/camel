/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.choise;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new MyRoute());
                
        ctx.start();
        ProducerTemplate template = ctx.createProducerTemplate();        
        template.sendBody("direct:a", "Boris");
    }
    
}
