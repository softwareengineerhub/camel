/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch01.completion.size;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyAggregatorSimpleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Recieved Message is ${body} and key ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new MyAggregatorSimpleRouteStrategy())
                .completionSize(3)
                .log("Aggregated Message is ${body}")
                .to("file:output?fileName=data.txt");
    }
    
}
