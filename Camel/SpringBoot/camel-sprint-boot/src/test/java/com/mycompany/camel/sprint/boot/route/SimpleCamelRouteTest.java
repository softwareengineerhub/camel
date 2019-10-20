/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.sprint.boot.route;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author dprokopiuk
 */
@ActiveProfiles("dev")
@RunWith(CamelSpringBootRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class SimpleCamelRouteTest {

    @Autowired
    private ProducerTemplate producerTemplate;
    @Autowired
    private Environment environment;
    
    
    public static void startCleanUp() throws Exception {
        FileUtils.cleanDirectory(new File("data/input"));
        FileUtils.deleteDirectory(new File("data/output"));
    }

    @Test
    public void testMoveFile() throws Exception {
        String message = "type,sku#,itemdescription,price\n"
                + "ADD,100,Samsung tv, 500\n"
                + "ADD,101,LG TV, 500";
        
        String fileName = "fileTest.txt";
        producerTemplate.sendBodyAndHeader(environment.getProperty("fromRoute"), message,Exchange.FILE_NAME, fileName);
        Thread.sleep(3000);
        
        File outFile = new File("data/output/"+fileName);
        assertTrue(outFile.exists());
        List<String> list =  Files.readAllLines(Paths.get(outFile.toURI()));
        assertTrue(list.size()==3);
        Assert.assertEquals(list.get(0), "type,sku#,itemdescription,price");
        Assert.assertEquals(list.get(1), "ADD,100,Samsung tv, 500");
        Assert.assertEquals(list.get(2), "ADD,101,LG TV, 500");
    }

}
