/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class DaoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        onException(Exception.class)
                .handled(true)
                .log("##########Exception While inserting messages.#######")
                .process(new ExceptionProcessor());
        
        from("direct:dbInput")
                .to("log:level=INFO&showBody=true")
                .process(new InsertProcessor())
                .to("jdbc:myDataSource")
                .to("sql:select * from country_capital?dataSource=myDataSource")
                .to("log:?level=INFO&showBody=true");
    }

}
