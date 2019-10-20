/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.xslt.fromfile;

import javax.sql.DataSource;
import javax.xml.transform.TransformerFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
//import org.apache.xalan.xsltc.trax.SmartTransformerFactoryImpl;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        SimpleRegistry registry = new SimpleRegistry();
        //TransformerFactory factory = new SmartTransformerFactoryImpl();        
        registry.put("tFactory", new org.apache.xalan.xsltc.trax.TransformerFactoryImpl());
        
        CamelContext ctx = new DefaultCamelContext(registry);
        
        ctx.addRoutes(new FileReadRoute());        
        
        ctx.start();
        Thread.sleep(3000);
        ctx.stop();
    }
    
}
