/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample02;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

/**
 *
 * @author dprokopiuk
 */
public class Main {

    public static void main(String[] args) throws Exception {
        InputStream xml = sample01.Main.class.getResourceAsStream("/sample02/school.xml");
        InputStream xslt = sample01.Main.class.getResourceAsStream("/sample02/dataTransformation.xslt");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();        
        Document document = builder.parse(xml);
        
        StreamSource style = new StreamSource(xslt);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(style);
        
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);        
        transformer.transform(source, result);        
    }

}
