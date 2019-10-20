/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jms;

import org.apache.camel.component.jms.DefaultJmsMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author dprokopiuk
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {        
        DefaultJmsMessageListenerContainer cm = null;
        
        System.setProperty("server.port", "9090");
        SpringApplication.run(Main.class, args);
    }

}
