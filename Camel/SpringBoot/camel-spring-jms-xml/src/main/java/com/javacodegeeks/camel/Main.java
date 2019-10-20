/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("mySampleConfig.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        try {
            camelContext.start();
            //     ProducerTemplate template = camelContext.createProducerTemplate();
            //    for (int i = 0; i < 5; i++) {
            //      template.sendBody("activemq:queue:start", "body" + i);
            //  }
            // Thread.sleep(1000);
        } finally {
            //camelContext.stop();
            //appContext.close();
        }
    }

}
