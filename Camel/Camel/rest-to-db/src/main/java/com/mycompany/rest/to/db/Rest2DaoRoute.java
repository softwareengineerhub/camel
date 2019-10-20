/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import java.sql.SQLException;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class Rest2DaoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {        
        
        
         from("direct:restToDb")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("http://restcountries.eu/rest/v2/alpha/ua"))               
                .to("https://restcountries.eu/rest/v2/alpha/${body}")
                 .convertBodyTo(String.class)
                .to("log:?level=INFO&showBody=true")
                .to("direct:dbInput");
    }
    
}
