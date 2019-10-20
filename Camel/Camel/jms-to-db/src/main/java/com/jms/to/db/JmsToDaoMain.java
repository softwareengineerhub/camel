/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.to.db;

import javax.sql.DataSource;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

/**
 *
 * @author dprokopiuk
 */
public class JmsToDaoMain {
    
    public static void main(String[] args) throws Exception {
        SimpleRegistry registry = new SimpleRegistry();
        DataSource ds = Utils.setupDataSource();
        registry.put("myDataSource", ds);
        CamelContext ctx = new DefaultCamelContext(registry);

        ctx.addRoutes(new JmsToDaoRoute());
        ctx.start();

        
       
    }
    
}
