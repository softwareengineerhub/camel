/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyRestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:restCall")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.HTTP_URI, simple("http://restcountries.eu/rest/v2/alpha/ua"))
                .to("https://restcountries.eu/rest/v2/alpha/${body}")
                .to("log:?level=INFO&showBody=true");
    }

}
