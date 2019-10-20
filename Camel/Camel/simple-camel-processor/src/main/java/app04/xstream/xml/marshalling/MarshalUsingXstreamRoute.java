/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app04.xstream.xml.marshalling;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

/**
 *
 * @author dprokopiuk
 */
public class MarshalUsingXstreamRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:csvinput")
                .process(new CustomProcessorXStreamProcessor())
                .marshal(getDataFormat())
                .log("${body}");
    }

    private XStreamDataFormat getDataFormat() {
        XStreamDataFormat format = new XStreamDataFormat();
        Map<String, String> aliases = new HashMap();
        aliases.put("employee", Employee.class.getName());
        format.setAliases(aliases);
        return format;
    }

}
