/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author dprokopiuk
 */
@Configuration
public class MyConfig {
     
    @Bean
    public DataSource dataSource() {
        DataSource ds = DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost:3306/camel-spring")
                .username("root")
                .password("11111111")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
        return ds;
    }

}
