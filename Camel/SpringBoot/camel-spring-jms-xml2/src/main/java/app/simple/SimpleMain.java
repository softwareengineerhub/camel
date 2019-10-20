/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.simple;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author DProkopiuk
 */
public class SimpleMain {
    
    public static void main(String[] args) {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
        cf.setBrokerURL("tcp://localhost:61616");
        cf.setPassword("admin");
        cf.setUserName("admin");        
        
     /*   StringBuffer ub = new StringBuffer();
    ub.append("failover:(tcp://")
        .append(configuration.get("events.channel.default.host", "127.0.0.1")).append(":")
        .append(configuration.get("events.channel.default.port", "61616"))
        .append("?wireFormat.maxInactivityDuration=0)?maxReconnectAttempts=0");*/
        
    }
    
}
