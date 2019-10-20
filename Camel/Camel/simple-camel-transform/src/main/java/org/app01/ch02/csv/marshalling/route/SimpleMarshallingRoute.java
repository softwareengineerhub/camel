/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app01.ch02.csv.marshalling.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.csv.domain.Employee;

/**
 *
 * @author dprokopiuk
 */
public class SimpleMarshallingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(Employee.class);
        from("direct:objInput")
                .log("Recieved Message is ${body}")
                .marshal(bindy)
                .to("file:data/csv/output?fileName=output.txt");
    }

}
