/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app03.net.transform.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author dprokopiuk
 */
public class BeanMain {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new CamelModifyBeanRoute());

        context.start();
        
        String input = "1,b,c,d,e";
        ProducerTemplate template = context.createProducerTemplate();
        template.sendBody("direct:beanInput", input);

        Thread.sleep(5000);
        context.stop();
    }

    
    public void m(){
        Thread.yield();
    }
}
