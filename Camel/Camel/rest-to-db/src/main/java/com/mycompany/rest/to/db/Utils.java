/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.to.db;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author dprokopiuk
 */
public class Utils {

    public static DataSource setupDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUsername("root");
        bds.setPassword("11111111");
        bds.setUrl("jdbc:mysql://localhost:3306/camel");
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        return bds;
    }
}
