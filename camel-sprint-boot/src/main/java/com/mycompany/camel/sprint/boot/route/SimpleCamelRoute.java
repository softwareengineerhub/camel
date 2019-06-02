/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.sprint.boot.route;

import javax.annotation.PostConstruct;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author DProkopiuk
 */
@Component
public class SimpleCamelRoute extends RouteBuilder {

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        System.out.println("init()");
    }

    @Override
    public void configure() throws Exception {
        System.out.println("configure()");
        from("timer:hello?period=10s")
                .log("Timer Invoked and the body ${body}")
                .pollEnrich("file:data/input?delete=true&readLock=none")
                .to("file:data/output");
    }

}
