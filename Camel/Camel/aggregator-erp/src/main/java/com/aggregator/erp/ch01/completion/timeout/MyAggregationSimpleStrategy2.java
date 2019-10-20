/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch01.completion.timeout;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

/**
 *
 * @author dprokopiuk
 */
public class MyAggregationSimpleStrategy2 implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchng, Exchange newExchng) {
        if (oldExchng == null) {
            return newExchng;
        } else {
            String b1 = (String) oldExchng.getIn().getBody();
            String b2 = (String) newExchng.getIn().getBody();
            newExchng.getIn().setBody(b1 + b2);
            return newExchng;
        }
    }

}
