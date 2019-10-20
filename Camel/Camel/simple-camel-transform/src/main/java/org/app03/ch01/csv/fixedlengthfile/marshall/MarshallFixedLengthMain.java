/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app03.ch01.csv.fixedlengthfile.marshall;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.app03.ch01.csv.fixedlengthfile.marshall.route.FixedLengthMarshallRoute;

/**
 *
 * @author dprokopiuk
 */
public class MarshallFixedLengthMain {
    
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new FixedLengthMarshallRoute());
     
        context.start();
        
        Thread.sleep(5000);
        context.stop();
    }
    
}
