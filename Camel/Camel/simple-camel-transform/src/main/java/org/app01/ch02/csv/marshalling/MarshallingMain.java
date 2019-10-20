/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app01.ch02.csv.marshalling;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.csv.domain.Employee;
import org.app01.ch02.csv.marshalling.route.SimpleMarshallingRoute;

/**
 *
 * @author dprokopiuk
 */
public class MarshallingMain {

    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new SimpleMarshallingRoute());

        ctx.start();
        
        Employee emp = new Employee();
        emp.setFirstName("NameA");
        emp.setLastName("LastNameA");
        emp.setId("A");
        
        ProducerTemplate template = ctx.createProducerTemplate();
        template.sendBody("direct:objInput", emp);

        Thread.sleep(5000);
        ctx.stop();
    }

}
