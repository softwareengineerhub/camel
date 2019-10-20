/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.xslt.fromfile;

import java.io.IOException;
import java.io.InputStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class ReadXmlProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {        
        String xml = readFromFile("/data.xml");
        exchange.getIn().setBody(xml);
        System.out.println("-----------ReadXmlProcessor START--------------");
        System.out.println(exchange.getIn().getBody());
        System.out.println("-----------ReadXmlProcessor END--------------");
    }
    
    private String readFromFile(String path) {
        try (InputStream in = getClass().getResourceAsStream(path);) {
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
