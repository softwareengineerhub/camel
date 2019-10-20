/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app02.org.direct.route;

import org.apache.camel.builder.RouteBuilder;
import app02.org.direct.processor.MyDirectProcessor;

/**
 *
 * @author dprokopiuk
 */
public class DirectRouteSample extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Received Message @Before process")
                .process(new MyDirectProcessor())
                .log("Received Message is ${body} and headers are ${headers}")
                .to("file:processorOutput?fileName=output.txt");
    }
    
}
