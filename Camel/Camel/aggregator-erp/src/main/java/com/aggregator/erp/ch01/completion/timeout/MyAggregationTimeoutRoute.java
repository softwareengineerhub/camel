/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch01.completion.timeout;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyAggregationTimeoutRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator2")
                .log("Recieved Message is ${body} and the headers key is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new MyAggregationSimpleStrategy2())
                .completionSize(3).completionTimeout(3000)
                .log("Aggregated Message is ${body}")
                .to("file:output?fileName=data2.txt");
    }
    
}
