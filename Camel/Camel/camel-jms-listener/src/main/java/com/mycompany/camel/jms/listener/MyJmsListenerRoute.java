/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.jms.listener;

import java.net.SocketException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ShutdownRoute;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DProkopiuk
 */
public class MyJmsListenerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
      //  from("activemq:queue:myListener").errorHandler(defaultErrorHandler().maximumRedeliveries(2));
        
        
        
        

        
        from("activemq:queue:myListener?idleTaskExecutionLimit=1000")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchng) throws Exception {
                        System.out.println(exchng.getIn().getBody());
                    }
                });
        
        
    }

}
