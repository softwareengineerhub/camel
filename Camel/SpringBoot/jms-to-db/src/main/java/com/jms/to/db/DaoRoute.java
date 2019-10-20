/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.to.db;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sql.SqlProducer;




/**
 *
 * @author dprokopiuk
 */
public class DaoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:dbInput")
                .to("log:?level=INFO&showBody=true")
                .process(new SQLProcessor())
                .to("jdbc:myDataSource");
    }
    
}
