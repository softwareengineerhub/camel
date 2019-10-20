/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.choise;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:a")
                .choice()
                    .when(bodyAs(String.class).isEqualTo("Denis"))
                        .log("------Denis------")
                    .when(bodyAs(String.class).isEqualTo("Piter"))
                        .log("------Piter------")
                    .when(bodyAs(String.class).isEqualTo("Boris"))
                        .log("------Boris------")    
                    .otherwise()
                        .log("------Default------")
                .endChoice()
            .end();
                        
    }

}
