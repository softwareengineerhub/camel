/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.sprint.boot.route;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author asusadmin
 */
@ActiveProfiles("mock")
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SimpleCamelRouteMockTest extends CamelTestSupport {
    
    @Autowired
    private CamelContext context;
    @Autowired
    private Environment environment;
    @Autowired
    private ProducerTemplate producerTemplate;
    
    @Test
    public void testMoveFileMock(){
    /*    String message = "some data";
        String startRoute = environment.getProperty("startRoute");
        producerTemplate.sendBodyAndHeader(startRoute, message, "env");*/
    }
    
    @Autowired
    @Override
    public CamelContext createCamelContext(){
        return context;
    }
    
}
