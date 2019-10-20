/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel.filecopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 *
 * @author dprokopiuk
 */
public class DirectComponentCopyFilesRouteTest extends CamelTestSupport {

    {
        try {
            File file = new File("sampleOutput");
            Path path = file.toPath();
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                System.out.println("---------------configure()---------------");
                from("direct:directTest/sampleInput")
                        .log("Recieved Message is ${body} and Headers are ${headers}")
                        .to("file:sampleOutput?fileName=output.txt");
            }
        };
    }

    @Test
    public void testRoute() throws InterruptedException, InvalidPayloadException {
        template.sendBody("direct:directTest/sampleInput", "1234, Data");
        
        Thread.sleep(5000);
        
        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());
        assertEquals(1, file.list().length);
        
        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
        exchange.getIn().getBody();
        //assertEquals("1234, Data", exchange.getIn().getMandatoryBody()+"");                
    }

}
