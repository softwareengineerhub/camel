/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.xslt;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyMessageListenerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:xmlQueue2?concurrentConsumers=2")
                //.process(new MyProcessor());
                .to("xslt:data.xslt")
                .log("${body}");
    }

}
