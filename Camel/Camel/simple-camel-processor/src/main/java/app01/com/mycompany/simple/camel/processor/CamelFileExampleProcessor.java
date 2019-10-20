/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app01.com.mycompany.simple.camel.processor;

import java.io.File;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;



/**
 *
 * @author dprokopiuk
 */
public class CamelFileExampleProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        System.out.println("Exchange in Processor is : "+exchng.getIn().getBody());
        GenericFile<File> file = (GenericFile<File>) exchng.getIn().getBody();
        Object body=file.getBody();
        System.out.println(body);
    }
    
}
