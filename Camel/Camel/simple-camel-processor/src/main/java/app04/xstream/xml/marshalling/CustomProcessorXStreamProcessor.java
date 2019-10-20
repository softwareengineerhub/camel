/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app04.xstream.xml.marshalling;

import java.util.StringTokenizer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class CustomProcessorXStreamProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String newBody = exchng.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
        Employee employee = new Employee();
        while (tokenizer.hasMoreElements()) {
            employee.setName((String) tokenizer.nextElement());
            employee.setId((String) tokenizer.nextElement());
            employee.setJoinDate((String) tokenizer.nextElement());
        }
        exchng.getIn().setBody(employee);

    }

}
