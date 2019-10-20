/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.camel;

import java.util.Arrays;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.DefaultJmsMessageListenerContainer;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultConsumerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.util.backoff.FixedBackOff;

/**
 *
 * @author DProkopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //ActiveMQQueue amqq = new ActiveMQQueue();
        
       // DefaultJmsListenerContainerFactory 
        //ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
        //cf.setBrokerURL("");
        
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("mySampleConfig.xml");     
        String[] names = appContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
        DefaultConsumerTemplate res = (DefaultConsumerTemplate) appContext.getBean("consumerTemplate");
        System.out.println(res);
        
        
        //DefaultJmsMessageListenerContainer ttt = appContext.getBean(DefaultJmsMessageListenerContainer.class);
        //ttt.setBackOff(new FixedBackOff());
        
      //  CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        
        //ConnectionFactory cf = appContext.getBean(requiredType);
       // camelContext.addComponent("jms", JmsComponent.jmsComponent(configuration));
        
        try {
           // camelContext.start();
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
