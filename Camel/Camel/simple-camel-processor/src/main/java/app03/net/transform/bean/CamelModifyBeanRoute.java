/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app03.net.transform.bean;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class CamelModifyBeanRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .bean(new CamelBean())
                .log("${body}");        
    }

}
