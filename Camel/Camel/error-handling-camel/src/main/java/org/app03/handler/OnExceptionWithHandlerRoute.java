/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app03.handler;

import java.sql.SQLException;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.app02.myhandler.BDataModifier;

/**
 *
 * @author dprokopiuk
 */
public class OnExceptionWithHandlerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
                
        onException(SQLException.class).log(LoggingLevel.INFO, "SQLException in Bean caught here");
        onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(2000).process(new MyErrorProcessor()).log(LoggingLevel.INFO, "Exception in Bean caught here");
                

        from("direct:exception3")
                .bean(new BDataModifier(), "mapOnException")
                .log("${body}");
    }

}
