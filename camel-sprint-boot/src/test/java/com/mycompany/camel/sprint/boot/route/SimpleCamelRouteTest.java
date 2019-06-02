/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.sprint.boot.route;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import junit.framework.Assert;
import static junit.framework.TestCase.assertEquals;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author asusadmin
 */
@ActiveProfiles(profiles = {"dev"})
@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class SimpleCamelRouteTest {

    @Autowired
    private ProducerTemplate producerTemplate;
    @Autowired
    private Environment environment;
    private String fileName = "fileTest.txt";

    @Test
    public void testMoveFile() throws Exception {
        String message = "sometext";        
        String fromRoute = environment.getProperty("fromRoute");
        producerTemplate.sendBodyAndHeader(fromRoute, message, Exchange.FILE_NAME, fileName);
        Thread.sleep(5000);
        String content = new String(Files.readAllBytes(Paths.get(new File("data/output/" + fileName).toURI())));
        assertEquals(message, content);
    }

    @After
    public void after() throws IOException {
        Path path = Paths.get(new File("data/output/" + fileName).toURI());
        Files.deleteIfExists(path);
    }

}
