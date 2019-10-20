/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app02.net.transform.simple;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class CamelModifyTransformRoute extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        from("direct:transformInput").transform(body().regexReplaceAll(",", "*")).log("${body}").to("file:transformMain?noop=true&fileName=transformMain.txt");
    }
    
}
