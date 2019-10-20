/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.jms.listener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {        
        CamelContext ctx = new DefaultCamelContext();
     //   ctx.addComponent("jms", JmsComponent.jmsComponent(new ActiveMQConnectionFactory("tcp://localhost:61612")));
        
        ctx.addRoutes(new MyJmsListenerRoute());
        ctx.start();
        //Thread.sleep(Long.MAX_VALUE);
        
    }
    
}
