/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.validation;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyValidationRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        onException(Exception.class)
                .handled(false)
                .log("Exception Stack: ${exception.stacktrace}");
        
        from("activemq:queue:xmlQueue?concurrentConsumers=2")
                .to("validator:META-INF/xml/schema/maven-4.0.0.xsd")
                .log("${body}");
    }
    
}
