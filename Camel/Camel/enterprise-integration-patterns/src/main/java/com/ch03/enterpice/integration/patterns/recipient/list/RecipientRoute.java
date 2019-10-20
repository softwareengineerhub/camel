/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch03.enterpice.integration.patterns.recipient.list;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class RecipientRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {        
        from("file:xmlinput?noop=true")
                .setHeader("type", xpath("/employee/@type"))
                .process(new RecipientProcessor())
                .recipientList(header("type"));        
    }

}
