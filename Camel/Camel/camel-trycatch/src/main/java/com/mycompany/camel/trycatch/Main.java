/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.trycatch;

import org.apache.camel.CamelContext;
import org.apache.camel.ShutdownRoute;
import org.apache.camel.builder.ErrorHandlerBuilderSupport;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();        
        
        MyRoute myRoute = new MyRoute();
        //myRoute.setErrorHandlerBuilder(ErrorHandlerBuilder.);
        ctx.addRoutes(new MyRoute());
        
        ctx.start();
        Thread.sleep(5000);
        
        ctx.stop();
    }
    
}
