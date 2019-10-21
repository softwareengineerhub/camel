package com.app;

import org.apache.camel.impl.DefaultCamelContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

public class MyContext {//extends DefaultCamelContext {

    @PostConstruct
    public void init() {
        System.out.println(hashCode()+"#####################################init()################################");
     //   setName("custom");
        // Disable JMX
        //disableJMX();

    }

    @PreDestroy
    public void cleanUp() {
        // ...
    }

}
