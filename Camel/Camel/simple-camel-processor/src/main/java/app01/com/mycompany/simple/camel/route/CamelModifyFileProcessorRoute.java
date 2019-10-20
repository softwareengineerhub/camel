/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app01.com.mycompany.simple.camel.route;

import app01.com.mycompany.simple.camel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class CamelModifyFileProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Read file is ${body} and headers are ${headers}")
                .to("file:data/output?fileName=output.txt")
                .process(new CamelFileExampleProcessor());
    }

}
