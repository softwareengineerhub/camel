package com.app;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyConsoleProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());
    }
}
