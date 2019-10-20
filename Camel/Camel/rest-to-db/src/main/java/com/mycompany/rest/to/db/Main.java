/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import javax.sql.DataSource;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DataSource ds = Utils.setupDataSource();

        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource", ds);

        CamelContext ctx = new DefaultCamelContext(registry);
        ctx.addRoutes(new MyRestRoute());

        ctx.start();
        ProducerTemplate template = ctx.createProducerTemplate();
        String response = template.requestBody("direct:restCall", "UA", String.class);
        System.out.println(response);

        Thread.sleep(5000);
    }

}
