/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app01.defaulthandler;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class DefaultErrorHandlerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        errorHandler(defaultErrorHandler().maximumRedeliveries(2).redeliveryDelay(3000).backOffMultiplier(2).retryAttemptedLogLevel(LoggingLevel.WARN));
        
        from("direct:exception").bean(new ADataModifier(), "map").log("${body}");
        //from("direct:exception").log("qqq");
    }

}
