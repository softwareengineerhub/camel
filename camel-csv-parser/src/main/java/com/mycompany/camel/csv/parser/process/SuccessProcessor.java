/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.csv.parser.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class SuccessProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        exchng.getIn().setBody("Data Updated Successfully");
    }

}
