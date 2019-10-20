/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app04.xstream.xml.unmarshalling;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class UnmarshalXmlMain {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new UnmarshalUsingXstreamRoute());

        context.start();

        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>b</id><name>a</name><joinDate>c</joinDate></employee>";
        ProducerTemplate template = context.createProducerTemplate();
        template.sendBody("direct:xmlInput", input);

        Thread.sleep(5000);
        context.stop();
    }

}
