/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.to.db;

import java.sql.SQLException;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class JmsToDaoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        onException(SQLException.class).handled(true).log("").process(new ExceptionProcessor());
        
        
        from("activemq:queue:testQueue2")
                .to("log:level=INFO&showBody=true")
                .process(new SQLProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from messages?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true");
    }
    
}
