/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel.filecopy;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
           
            @Override
            public void configure() throws Exception {
                System.out.println("START1" +Thread.currentThread().getName());
                Thread.sleep(3000);
                from("file:data/input?noop=true")
                        .to("log:?level=INFO&showBody=true")
                        .to("file:data/output");
                System.out.println("END1");
            }
        });
        
        context.addRoutes(new RouteBuilder() {
           
            @Override
            public void configure() throws Exception {
                System.out.println("START2" +Thread.currentThread().getName());
                Thread.sleep(3000);
                from("file:data/input2?noop=true")
                        .to("log:?level=INFO&showBody=true")
                        .to("file:data/output")
                        .to("file:data/output2");
                System.out.println("END2");
            }
        });        
        context.start();
        Thread.sleep(10000);
        //context.stop();
    }
    
}
