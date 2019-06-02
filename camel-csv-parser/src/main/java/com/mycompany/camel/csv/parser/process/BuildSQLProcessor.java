/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.csv.parser.process;

import com.mycompany.camel.csv.parser.domain.Item;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class BuildSQLProcessor implements Processor {

    private Logger log = Logger.getLogger(getClass());

    @Override
    public void process(Exchange exchng) throws Exception {
        Item item = exchng.getIn().getBody(Item.class);
        log.info("#############################" + item);
        String query = null;
        if ("ADD".equals(item.getTransactionType())) {
            query = String.format("INSERT INTO ITEMS(SKU, itemDESCRIPTION, PRICE) values('%s','%s','%s')", item.getSku(), item.getItemDescription(), item.getPrice());
        } else if ("UPDATE".equals(item.getTransactionType())) {
            query = String.format("UPDATE ITEMS SET PRICE='%s' WHERE sku='%s'", item.getPrice(), item.getSku());
        } else if ("DELETE".equals(item.getTransactionType())) {
            query = String.format("DELETE FROM ITEMS WHERE sku='%s'", item.getSku());
        } else if ("ERROR".equals(item.getTransactionType())) {
            query = String.format("DELETE_ FROM ITEMS WHERE sku='%s'", item.getSku());
        }
        
        log.info("#############################query=" + query);
        exchng.getIn().setBody(query);
    }

}
