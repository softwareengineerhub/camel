package com.mycompany.camel.csv.parser.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigDecimal;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 *
 * @author asusadmin
 */
@CsvRecord(separator = ",", skipFirstLine = true)
public class Item {
    @DataField(pos=1)
    private String transactionType;
    @DataField(pos=2)
    private String sku;
    @DataField(pos=3)
    private String itemDescription;
    @DataField(pos=4)
//    private BigDecimal price;
    private String price;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "transactionType=" + transactionType + ", sku=" + sku + ", itemDescription=" + itemDescription + ", price=" + price + '}';
    }
    
}
