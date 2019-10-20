package com.app.routes;

import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyJmsCamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:inputItemQueue")
                .log("${body}").to("file:data/output?fileName=message.txt");;
    }
}
