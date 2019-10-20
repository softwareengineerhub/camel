/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.cdi.denis;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author DProkopiuk
 */
@ApplicationScoped
@Named("myCamelName")
public class CustomCamelContext extends DefaultCamelContext {

    @PostConstruct
    public void init() {
        System.out.println("#####################################init()################################");
        setName("custom");
        // Disable JMX
        //disableJMX();
        
    }

    @PreDestroy
    public void cleanUp() {
        // ...
    }

}
