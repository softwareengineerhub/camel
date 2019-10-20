/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author DProkopiuk
 */
public class ActiveMqRouteBuilder extends RouteBuilder {

    @Override
    public void configure() {
        from("activemq:queue:start")
                .to("bean:testBean?method=hello")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchng) throws Exception {
                        System.out.println(exchng.getIn().getBody());
                    }

                });
    }
}
