/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app03.handler;

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
        ctx.addRoutes(new OnExceptionWithHandlerRoute());

        ctx.start();
        //String input = "1,2,3,4";
        String input = null;
        ProducerTemplate tempate = ctx.createProducerTemplate();
        tempate.sendBody("direct:exception3", input);

        Thread.sleep(5000);
        ctx.stop();
    }

}
