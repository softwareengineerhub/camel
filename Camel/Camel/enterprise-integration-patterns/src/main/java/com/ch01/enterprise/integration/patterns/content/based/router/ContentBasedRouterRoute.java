/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.enterprise.integration.patterns.content.based.router;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk noop - do not perform any operation after moving the
 * content
 */
public class ContentBasedRouterRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input?noop=true")
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .choice()
                .when(header("CamelFileNameConsumed").endsWith(".html"))
                .to("file:output/html")
                .when(header("CamelFileNameConsumed").endsWith(".txt"))
                .to("file:output/text")
                .when(header("CamelFileNameConsumed").endsWith(".json"))
                .to("file:output/json")
                .otherwise().to("file:output/other")
                .end()
                
                .to("file:output/all");
    }

}
