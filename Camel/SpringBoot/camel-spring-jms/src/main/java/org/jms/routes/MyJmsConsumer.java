/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jms.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.jms.domain.Person;
import org.jms.processor.VlidateDataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dprokopiuk
 */
@Component
public class MyJmsConsumer extends RouteBuilder {
    
    @Autowired
    private VlidateDataProcessor vlidateDataProcessor; 

    @Override
    public void configure() throws Exception {
        
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Person.class);

        from("activemq:inputItemQueue")
                .log("${body}")
                .unmarshal(gsonDataFormat)
                .process(vlidateDataProcessor)
                .log("${body}");
    }

}
