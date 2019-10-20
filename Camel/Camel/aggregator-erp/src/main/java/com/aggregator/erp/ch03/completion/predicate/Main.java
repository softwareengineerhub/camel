/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch03.completion.predicate;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new AggregateWithCompletionPredicateRoute());

        ctx.start();
        
        String oredCreated = "12345,lg=phone,order-created";
        String oredConfirm = "12345,lg=phone,order-confirm";
        
        ProducerTemplate template = ctx.createProducerTemplate();
        template.sendBodyAndHeader("direct:completionPredicate", "A", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:completionPredicate", oredCreated, "aggregatorId", 1);
        template.sendBodyAndHeader("direct:completionPredicate", oredConfirm, "aggregatorId", 1);
        

        Thread.sleep(5000);
        ctx.stop();
    }

}
