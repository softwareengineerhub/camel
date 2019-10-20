/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myxpath.app01;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        InputStream xml = Main.class.getResourceAsStream("/myxpath/app01/app01.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xml);
        
        XPath xPath = XPathFactory.newInstance().newXPath();        
        String expression = "/Tutorials/Tutorial";        
        
        //We can compile an XPath expression passed as string and define what kind of data we are expecting to receive such a NODESET, NODE or String for example.
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);            
            System.out.println(node.getNodeName());
        }                
        
        
        
        System.out.println("---------------Get by specific id-----------------------------");
        String id = "01";        
        expression = "/Tutorials/Tutorial[@tutId=" + "'" + id + "'" + "]";
        nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);            
            System.out.println(node.getNodeName());
        }                
        
        
        System.out.println("---------------Get by specific tag name-----------------------------");
        String name = "Guava";
        expression = "//Tutorial[descendant::title[text()=" + "'" + name + "'" + "]]";
        nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);            
            System.out.println(node.getNodeName());
        }
        
        
        
        System.out.println("---------------Manipulating Data in Expressions-----------------------------");
        String date = "04052015";
        expression = "//Tutorial[number(translate(date, '/', '')) > " + date + "]";
        nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);            
            System.out.println(node.getNodeName());
        }
        
    }
    
}
