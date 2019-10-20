/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.cdi.denis;

import java.net.SocketException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ShutdownRoute;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author DProkopiuk
 */
public class MyJmsListenerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:myListener")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchng) throws Exception {
                        System.out.println(exchng.getIn().getBody());
                    }
                });

    }

}
