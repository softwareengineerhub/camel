/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch04.grouped.exchange;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

/**
 *
 * @author dprokopiuk
 */
public class AggregateWithGroupExchangeRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:grpAggregator")
                .log("Recieved Message is ${body} and headers are ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                .completionSize(3)
                .process(new MyExchangeProcessor())
                .log("Aggregated Messages are ${body}");
    }

}
