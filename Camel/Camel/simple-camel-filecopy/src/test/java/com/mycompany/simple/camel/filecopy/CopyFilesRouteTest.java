/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel.filecopy;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import java.io.File;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 *
 * @author dprokopiuk
 */
public class CopyFilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                System.out.println("---------------configure()---------------");
                from("file:datatest/input?noop=true")
                        .to("log:?level=INFO&showBody=true&showHeaders=true")
                        .to("file:datatest/output");
            }
        };
    }

    @Test
    public void testRoute() throws InterruptedException {        
       // template.sendBody("direct:sampleInput", "1234, Dilip");
        Thread.sleep(5000);
        
        File file = new File("datatest/output");
        assertTrue(file.isDirectory());
        assertEquals(1, file.list().length);
    }

}
