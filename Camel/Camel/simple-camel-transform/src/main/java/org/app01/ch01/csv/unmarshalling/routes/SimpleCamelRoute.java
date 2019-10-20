/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app01.ch01.csv.unmarshalling.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.csv.domain.Employee;

/**
 *
 * @author dprokopiuk
 */
public class SimpleCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(Employee.class);
        from("file:data/csv/input?fileName=data.csv&noop=true")
                .unmarshal(bindy)
                .log("unMarshaled Message is ${body}");
                //.to("direct:output");
    }

}
