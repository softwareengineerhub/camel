/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.jms.domain.Person;
import org.springframework.stereotype.Component;

/**
 *
 * @author dprokopiuk
 */
@Component
public class VlidateDataProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        Person person = (Person) exchng.getIn().getBody();
        System.out.println("--------Validation of person-----------");
        
        System.out.println("--------Person is valid-----------");
    }
    
}
