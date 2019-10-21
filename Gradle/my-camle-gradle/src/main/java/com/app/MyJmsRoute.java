package com.app;

import org.apache.camel.builder.RouteBuilder;

import javax.inject.Inject;

public class MyJmsRoute extends RouteBuilder {

    @Inject
    private MyConsoleProcessor myConsoleProcessor;

    @Override
    public void configure() throws Exception {
        System.out.println("!!!!!!!MyJmsRoute.configure()");
        from("activemq:queue:myListener").process(myConsoleProcessor);
    }
}
