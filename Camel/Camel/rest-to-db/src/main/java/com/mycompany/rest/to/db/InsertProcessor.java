/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author dprokopiuk
 */
public class InsertProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {

        //System.out.println(exchng.getIn().getBody());
        String input = (String) exchng.getIn().getBody();
        System.out.println("Input to be persisted : " + input);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(input);

        JSONObject jsonObject = (JSONObject) obj;
        String name = (String) jsonObject.get("name");
        String capital = (String) jsonObject.get("capital");
        String sql = String.format("INSERT INTO country_capital(name, capital) values('%s', '%s')", name, capital);
        System.out.println(sql);
        exchng.getIn().setBody(sql);
    }

}
