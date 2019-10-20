/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.to.db;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class JmsReadRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:testQueue")
                .to("log:level=INFO&showBody=true")
                .to("direct:readQueue");
    }
    
}
