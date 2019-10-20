/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app02.org.direct.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class MyDirectProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        System.out.println("MyDirectProcessor: "+exchng.getIn().getBody());
        exchng.getIn().setBody("A,B,C,D,2");
    }
    
}
