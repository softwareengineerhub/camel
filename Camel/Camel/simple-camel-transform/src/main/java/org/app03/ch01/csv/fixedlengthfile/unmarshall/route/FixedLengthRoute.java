/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app03.ch01.csv.fixedlengthfile.unmarshall.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;
import org.csv.domain.EmployeeWithFixedLength;

/**
 *
 * @author dprokopiuk
 */
public class FixedLengthRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);
        from("file:data/csv/input?fileName=fixedLength.txt&noop=true")
                .unmarshal(bindy)
                .log("${body}");
    }

}
