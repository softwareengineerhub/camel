package com.app;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.*;
import java.io.File;
import java.nio.file.Files;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(CamelSpringBootRunner.class)
//@SpringBootTest(classes = {TestConfig.class})
@SpringBootTest
public class JmsRoutTest {
    @Autowired
    private ConnectionFactory connectionFactory;

    @Test
    public void testJmsConsumer() throws Exception {
        File file = new File("data/output/message.txt");
        if (file.exists()) {
            file.delete();
        }


        Connection c = connectionFactory.createConnection();
        Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(new ActiveMQQueue("inputItemQueue"));
        String text = "qqqqq";
        Message msg = session.createTextMessage(text);
        messageProducer.send(msg);
        Thread.sleep(2000);
        assertTrue(file.exists());

        String result = new String(Files.readAllBytes(file.toPath()));
        assertEquals(result, text);
    }

}
