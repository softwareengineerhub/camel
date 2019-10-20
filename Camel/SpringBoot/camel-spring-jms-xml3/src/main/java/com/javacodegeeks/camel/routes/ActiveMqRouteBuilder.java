/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.camel.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author DProkopiuk
 */
public class ActiveMqRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {

      /*  defaultErrorHandler()
                .maximumRedeliveries(-1)
                .useExponentialBackOff()
                .backOffMultiplier(2)
                .maximumRedeliveryDelay(10000)
                .redeliveryDelay(500);*/
        
        
        from("activemq:queue:start")
                .to("bean:testBean?method=hello")
                .to("stream:out");
    }
}
