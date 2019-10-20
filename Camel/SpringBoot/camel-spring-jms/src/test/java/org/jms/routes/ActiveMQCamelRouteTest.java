/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jms.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;

/**
 *
 * @author dprokopiuk
 */

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ActiveMQCamelRouteTest extends CamelTestSupport {
    @Autowired
    private  CamelContext context;
    @Autowired
    private  ProducerTemplate producerTemplate;
    @Autowired
    private ConsumerTemplate consumerTemplate;
    @Autowired
    private Environment environment;    
    
    @Override
    protected CamelContext createCamelContext() {
        return context;
    }
    
    @Override
    protected RouteBuilder createRouteBuilder(){
        return new MyJmsConsumer();
    }
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void activeMQRoute(){
        String input = "{'name':'Denis','age':32}";        
        Object response = producerTemplate.requestBody("activemq:inputItemQueue", input);
        System.out.println(response);
    }
    
}
