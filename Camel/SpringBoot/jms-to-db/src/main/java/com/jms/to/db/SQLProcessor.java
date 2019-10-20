/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.to.db;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author dprokopiuk
 */
public class SQLProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String body = (String) exchng.getIn().getBody();
        String sql = String.format("INSERT INTO messages (msg) values('%s')", body);
        exchng.getIn().setBody(sql);
    }

}
