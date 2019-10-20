package com.app;

import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertTrue;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = {TestConfig.class})
public class SpringConfigTest {

    @Autowired
    private String someData;

    @Test
    public void test(){
        System.out.println("!!!!!!!!!!someData="+someData);
        assertTrue("B".equals(someData));
    }
}
