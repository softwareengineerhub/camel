/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aggregator.erp.ch01.completion.size;

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
        ctx.addRoutes(new MyAggregatorSimpleRoute());

        ctx.start();

        ProducerTemplate template = ctx.createProducerTemplate();
        template.sendBodyAndHeader("direct:simpleAggregator", "A", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "B", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "C", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "D", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "E", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "F", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 2);
        //template.sendBodyAndHeader("direct:simpleAggregator", "0", "aggregatorId", 2);
        //template.sendBody("direct:simpleAggregator", "B");
        //template.sendBody("direct:simpleAggregator", "C");
        
        Thread.sleep(5000);
        ctx.stop();
    }

}
