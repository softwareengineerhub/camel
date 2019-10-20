package com.mycompany.camel.cdi.denis;

import javax.inject.Inject;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.Uri;

public class DenisRouteA extends RouteBuilder {
    
        
    @Inject
    @Uri("timer:a?period=5500")
    private Endpoint endpointA;

    @Override
    public void configure() {
        // you can configure the route rule with Java DSL here

        from("timer:a?period=5500").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                System.out.println("!!!!DenisRouteA!!!!");
            }
        });
            
    }

}
