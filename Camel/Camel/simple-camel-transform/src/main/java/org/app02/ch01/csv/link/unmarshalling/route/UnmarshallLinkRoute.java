/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch01.csv.link.unmarshalling.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.csv.domain.EmployeeWithAddress;

/**
 *
 * @author dprokopiuk
 */
public class UnmarshallLinkRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);
        from("file:data/csv/input?noop=true&fileName=file-with-address.txt").unmarshal(bindy).log("${body}");
    }
    
}
