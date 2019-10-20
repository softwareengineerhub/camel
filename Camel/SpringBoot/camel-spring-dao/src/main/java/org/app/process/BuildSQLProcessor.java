/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.app.domain.Item;
import org.springframework.stereotype.Component;

/**
 *
 * @author dprokopiuk
 */
@Component
public class BuildSQLProcessor implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        Item item = (Item) exchng.getIn().getBody();
        System.out.println(" Item in Processor " + item);
        String sql = String.format("INSERT INTO items(transactionType, item_description, sku, price) VALUES('%s','%s','%s',%s)", item.getTransactionType(), item.getItemDescription(), item.getSku(), item.getPrice());
        System.out.println(" SQL = " + sql);
        exchng.getIn().setBody(sql);
    }

}
