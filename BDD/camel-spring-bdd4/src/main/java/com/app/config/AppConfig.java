/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.app.routes.MyJmsCamelRoute;
import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author DProkopiuk
 */
@Configuration
public class AppConfig {
    
  /*  @Bean
    public MyJmsCamelRoute myJmsCamelRoute(){
        return new MyJmsCamelRoute();
    }*/
    
    @Bean(name = "activemq")
    public ActiveMQComponent createComponent(ConnectionFactory factory) {
        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
        activeMQComponent.setConnectionFactory(factory);
        return activeMQComponent;
    }

/*    @Bean
    public ConnectionFactory getConnectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "vm://localhost?broker.persistent=false");
    }
*/
    @Bean
    public ConnectionFactory getConnectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
    }

    
}
