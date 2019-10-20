/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app06.camel.json;

import app04.xstream.xml.marshalling.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

/**
 *
 * @author dprokopiuk
 */
public class MarshalUsingGsonRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
        from("direct:marshalGSON").marshal(gsonDataFormat).log("${body}");
        from("direct:unmarshalGSON").unmarshal(gsonDataFormat).log("${body}");
    }

}
