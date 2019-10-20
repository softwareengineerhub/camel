/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch02.csv.link.marshalling.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.csv.domain.EmployeeWithAddress;

/**
 *
 * @author dprokopiuk
 */
public class MyMarshallingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:objLinkInput").marshal(new BindyCsvDataFormat(EmployeeWithAddress.class))
                .log("${body}");
    }

}
