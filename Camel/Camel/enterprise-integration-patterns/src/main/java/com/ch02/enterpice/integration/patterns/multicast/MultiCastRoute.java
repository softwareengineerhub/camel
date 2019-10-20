/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.enterpice.integration.patterns.multicast;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class MultiCastRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //stop workflow in case of exception
        from("file:input/multicast?noop=true")
                .multicast()
                .stopOnException()
                .parallelProcessing()
                .to("file:output/multicast/d1", "file:output/multicast/d2");

        //sequential - default
        /*from("file:input/multicast?noop=true")
                .multicast()
                .parallelProcessing()
                .to("file:output/multicast/d1", "file:output/multicast/d2");*/
        //sequential - default
        /*from("file:input/multicast?noop=true")
                .multicast()
                .to("file:output/multicast/d1", "file:output/multicast/d2");*/
    }

}
