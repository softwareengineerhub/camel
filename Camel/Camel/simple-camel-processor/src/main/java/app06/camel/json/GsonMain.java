/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app06.camel.json;

import app04.xstream.xml.marshalling.Employee;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class GsonMain {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new MarshalUsingGsonRoute());
        
        context.start();        
        
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Name1");
        employee.setJoinDate("JoinDate1");
        
        ProducerTemplate template = context.createProducerTemplate();
        template.sendBody("direct:marshalGSON", employee);
        
        String input = "{\"id\":\"1\",\"name\":\"Name1\",\"joinDate\":\"JoinDate1\"}";
        template = context.createProducerTemplate();
        template.sendBody("direct:unmarshalGSON", input);
        
        Thread.sleep(5000);
        context.stop();
    }
    
}
