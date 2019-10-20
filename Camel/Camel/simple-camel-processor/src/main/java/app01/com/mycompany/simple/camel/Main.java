/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app01.com.mycompany.simple.camel;

import app01.com.mycompany.simple.camel.route.CamelModifyFileProcessorRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new CamelModifyFileProcessorRoute());
        context.start();
        Thread.sleep(5000);
        context.stop();
    }
    
}
