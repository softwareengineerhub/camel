/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app05.xml.to.json;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

/**
 *
 * @author dprokopiuk
 */
public class XmlToJsonRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:marshalEmployeexml2json").to("log:?level=INFO&showBody=true")
                .marshal()
                .xmljson()
                .to("log:?level=INFO&showBody=true");
        
        
        XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
        xmlJsonFormat.setRootName("Employee");
        
        from("direct:unmarshalEmployeexml2json").unmarshal(xmlJsonFormat).to("log:?level=INFO&showBody=true");        
    }
    
}
