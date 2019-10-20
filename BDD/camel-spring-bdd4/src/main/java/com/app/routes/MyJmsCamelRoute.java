package com.app.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class MyJmsCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        from("activemq:inputItemQueue").process(new Processor() {
            
            @Override
            public void process(Exchange exchng) throws Exception {
                System.out.println(exchng.getIn().getBody());
            }
        });
           
    }
}
