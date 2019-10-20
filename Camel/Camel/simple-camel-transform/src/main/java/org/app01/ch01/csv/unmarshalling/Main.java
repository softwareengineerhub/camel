/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app01.ch01.csv.unmarshalling;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.app01.ch01.csv.unmarshalling.routes.SimpleCamelRoute;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new SimpleCamelRoute());

        ctx.start();

        //ProducerTemplate template = ctx.createProducerTemplate();        
        //template.sendBody("direct:", "");        
        Thread.sleep(5000);
        ctx.stop();
    }

}
