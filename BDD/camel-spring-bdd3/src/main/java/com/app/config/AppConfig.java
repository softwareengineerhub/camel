package com.app.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.ConnectionFactory;

@Configuration
public class AppConfig {


    @Bean(name = "activemq")
    public ActiveMQComponent createComponent(ConnectionFactory factory) {
        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
        activeMQComponent.setConnectionFactory(factory);
        return activeMQComponent;
    }

    @Bean
    public ConnectionFactory getConnectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "vm://localhost?broker.persistent=false");
    }

    /*@Bean
    public ConnectionFactory getConnectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
    }*/

    @Bean
    public String someData() {
        return "A";
    }
}
