/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch01.completion.size;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 *
 * @author dprokopiuk
 */
public class MyAggregatorSimpleRouteStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchng, Exchange newExchng) {
        if (oldExchng == null) {
            return newExchng;
        } else {
            String oldBody = (String) oldExchng.getIn().getBody();
            String newBody = (String) newExchng.getIn().getBody();
            newBody = oldBody.concat(newBody);
            newExchng.getIn().setBody(newBody);
            return newExchng;
        }
    }

}
