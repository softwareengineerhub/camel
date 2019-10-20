/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.camel;

import org.apache.activemq.ActiveMQSession;
//import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.ConsumerType;
import org.apache.camel.component.jms.DefaultJmsMessageListenerContainer;
import org.apache.camel.component.jms.EndpointMessageListener;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
      //  ActiveMQSession  amqs = new ActiveMQXASession;
      //  amqs.close();
        
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("mySampleConfig.xml");
        
        
        
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        
        //DefaultJmsMessageListenerContainer container = appContext.getBean(DefaultJmsMessageListenerContainer.class);
        //Object myBean = camelContext.getComponentNames();
        //System.out.println("camelContext="+myBean);
        
        
        /*JmsComponent componenet = (JmsComponent) camelContext.getComponent("activemq");        
        System.out.println("componenet="+componenet);
        JmsConfiguration config = new JmsConfiguration();
        System.out.println("ConsumerType()="+config.getConsumerType());
        //config.setConsumerType(ConsumerType.Default);
        
        componenet.setConfiguration(config);*/
        
        
        
        //ActiveMQComponent ac = (ActiveMQComponent) componenet;
        //ac.createComponentConfiguration().
      
        
        try {
            camelContext.start();

        } catch(Exception ex) {
            ex.printStackTrace();

        //    DefaultJmsMessageListenerContainer container = appContext.getBean(DefaultJmsMessageListenerContainer.class);
            //     ProducerTemplate template = camelContext.createProducerTemplate();
            //    for (int i = 0; i < 5; i++) {
            //      template.sendBody("activemq:queue:start", "body" + i);
            //  }
            // Thread.sleep(1000);
        } finally {
            //camelContext.stop();
            //appContext.close();
        }
        Thread.sleep(500000);
    }

}
