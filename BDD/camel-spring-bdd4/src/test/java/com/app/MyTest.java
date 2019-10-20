/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.app.beans.UserService;
import com.app.routes.MyJmsCamelRoute;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author DProkopiuk
 */
@RunWith(CamelSpringRunner.class)
@SpringBootTest(classes = {MyTestConfig.class})
public class MyTest {
    
    @Autowired
    private MyJmsCamelRoute myJmsCamelRoute;    
    @Autowired
    private UserService userService;
    
    @Test
    public void makeTest() throws InterruptedException {
        System.out.println("myJmsCamelRoute="+myJmsCamelRoute);
        System.out.println("UserService="+userService);
        userService.doAction();
        Thread.sleep(1000);
    }
    
}
