/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xf.received;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import sample01.Main;

/**
 *
 * @author DProkopiuk
 */
public class ReceivedMain {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        InputStream xml = Main.class.getResourceAsStream("/xf/received/data_tmp.xml");
        InputStream xslt = Main.class.getResourceAsStream("/xf/received/data_tmp.xslt");
        //File xslt = new File("");

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xml);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        StreamSource style = new StreamSource(xslt);
        Transformer transformer = transformerFactory.newTransformer(style);

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }

}
