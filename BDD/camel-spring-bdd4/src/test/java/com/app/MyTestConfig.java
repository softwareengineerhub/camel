/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.routes.MyJmsCamelRoute;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author DProkopiuk
 */
@SpringBootApplication
public class MyTestConfig {
    
    @Bean
    public MyJmsCamelRoute myJmsCamelRoute(){
        return new MyJmsCamelRoute();
    }
    
}
