/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app03.org.direct;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import app02.org.direct.route.DirectRouteSample;

/**
 *
 * @author dprokopiuk
 */
public class DirectMain {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext context = new DefaultCamelContext();
        String input = "a,b,c,d,1";
        context.addRoutes(new DirectRouteSample());
        context.start();
        ProducerTemplate template = context.createProducerTemplate();
        template.sendBody("direct:processorInput", input);
        Thread.sleep(5000);
        context.stop();
    }

}
