/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch03.completion.predicate;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class AggregateWithCompletionPredicateRoute extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        from("direct:completionPredicate")
                .log("Received Message is ${body} and the header is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorPredicateStrategy())
                .log("-------------------${body}-------------------")
                .completionPredicate(body().contains("order-confirm"))
                .eagerCheckCompletion()
                .log("Final Message is : ${body}")
                .to("file:output?fileName=data3.txt");
    }
    
}
