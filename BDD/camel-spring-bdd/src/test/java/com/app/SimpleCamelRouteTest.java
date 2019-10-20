package com.app;


import org.apache.camel.CamelContext;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class SimpleCamelRouteTest {

    @Autowired
    private CamelContext camelContext;

    @Test
    public void test(){
        System.out.println("!!!!!!!!!!!!!!!!!!!camelContext="+camelContext);
        Assert.assertNotNull(camelContext);
    }

    @Test
    public void test2() throws Exception {
        File file = new File("data/input/filePut.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        Thread.sleep(11000);
        file = new File("data/output/filePut.txt");
        assertTrue(file.exists());
        file.delete();
    }

}
