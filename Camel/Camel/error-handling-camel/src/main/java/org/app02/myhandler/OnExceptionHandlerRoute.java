/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.myhandler;

import java.sql.SQLException;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class OnExceptionHandlerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        onException(RuntimeException.class, Exception.class).log(LoggingLevel.INFO, "Exception in Bean caught here");        
        //onException(RuntimeException.class, Exception.class).to("file:out?fileName=exception.log");                        
        //onException(RuntimeException.class, Exception.class).log("${exception.message}");
        onException(SQLException.class).log(LoggingLevel.INFO, "SQLException in Bean caught here");

        from("direct:exception2")
                .bean(new BDataModifier(), "mapOnException")
                .log("${body}");
    }

}
