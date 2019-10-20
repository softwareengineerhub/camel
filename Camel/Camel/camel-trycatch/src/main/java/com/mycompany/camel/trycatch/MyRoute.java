/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.trycatch;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {        
        onException(NullPointerException.class).handled(true).process(new MyExceptionHandler());
        
        /*from("file:in/data?fileName=person.properties&noop=true")                
                    .process(new MyProcessor())
                    .log("after processor ${body}")
                    .to("file:data/output")                       
                    .log("finally ${body}");                */
        
        from("file:in/data?fileName=person.properties&noop=true")
                .doTry()                
                    .process(new MyProcessor())
                    .log("after processor ${body}")
                    .to("file:data/output")
                .doCatch(Exception.class)
                    .process(new MyExceptionProcessor())
                .doFinally()                    
                    .log("finally ${body}")
                .end();
    }
    
}
