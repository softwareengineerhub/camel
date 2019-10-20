/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.routes;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.app.domain.Item;
import org.app.process.BuildSQLProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author dprokopiuk
 */
@Component
public class SimpleCamelRoute extends RouteBuilder {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource ds;

    @Autowired
    private BuildSQLProcessor buildSQLProcessor;

    @PostConstruct
    public void init() {
        System.out.println("init()");
    }

    @Override
    public void configure() throws Exception {
        log.info("Starting the Camel Route");
        DataFormat bindy = new BindyCsvDataFormat(Item.class);

        from("file:data/input")
                .to("file:data/output")
                .unmarshal(bindy)
                .log("${body}")
                .split(body())
                .log("${body}")
                .process(buildSQLProcessor)
                .to("jdbc:dataSource");
    }

}
