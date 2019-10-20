/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch04.enterpice.integration.patterns.wiretap;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class WiretapRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input/wiretap?noop=true")
                .wireTap("file:debug/wiretap")
                .to("file:all/wiretap");
    }

}
