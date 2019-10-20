/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.xslt;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;

/**
 *
 * @author dprokopiuk
 */
public class MyProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String xml = exchng.getIn().getBody() + "";
        InputStream xslt = getClass().getResourceAsStream("/META-INF/xslt/data.xslt");
        
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(xml);
        
        StreamSource style = new StreamSource(xslt);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(style);
        
        //DOMSource source = new DOMSource(document);
        //StreamResult result = new StreamResult(System.out);        
        //transformer.transform(source, result);                
        //System.out.println(xml);
        
    }
    
}
