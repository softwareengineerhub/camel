/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.myhandler;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new OnExceptionHandlerRoute());

        context.start();

        //String input = "w,e,r,t";
        String input = null;
        ProducerTemplate template = context.createProducerTemplate();
        template.sendBody("direct:exception2", input);

        Thread.sleep(5000);
        context.stop();
    }

}
