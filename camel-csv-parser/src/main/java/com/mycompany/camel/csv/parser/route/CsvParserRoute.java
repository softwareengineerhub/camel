/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.csv.parser.route;

import com.mycompany.camel.csv.parser.process.BuildSQLProcessor;
import com.mycompany.camel.csv.parser.domain.Item;
import com.mycompany.camel.csv.parser.process.SuccessProcessor;
import javax.sql.DataSource;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class CsvParserRoute extends RouteBuilder {

    @Autowired
    private Environment environment;
    private Logger log = Logger.getLogger(getClass());
    private int j;
    
    @Autowired
    @Qualifier("dataSource")
    private DataSource ds;
    @Autowired
    private BuildSQLProcessor buildSQLProcessor; 
    @Autowired
    private SuccessProcessor successProcessor;

    @Override
    public void configure() throws Exception {
        log.info("Starting the Camel Route");
        System.out.println("----------------------Starting the Camel Route----------------------");

        errorHandler(deadLetterChannel("log:errorInRoute?level=ERROR&showProperties=true"));
        
        int i = 0;
        String message = environment.getProperty("message");
        DataFormat bindy = new BindyCsvDataFormat(Item.class);
        from("{{startRoute}}")
                .log("Timer Invoked and the body" + message)
                .pollEnrich("{{fromRoute}}")
                .to("{{toRoute1}}")
                .unmarshal(bindy)
                .log("The unmarshaled object is ${body}")
                .split(body())
                .log(i+++"Record is ${body}; "+Thread.currentThread().getName()+"; "+j+++"; hashCode="+hashCode())
                .process(buildSQLProcessor)
                .to("{{toRoute2}}")
                .process(successProcessor)
                .to("{{toRoute3}}");
                
        
        System.out.println("----------------------Ending the Camel Route----------------------");
        log.info("Ending the Camel Route");
    }

}
