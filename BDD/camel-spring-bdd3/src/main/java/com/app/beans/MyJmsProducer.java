package com.app.beans;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MyJmsProducer {
    @Autowired
    private ConnectionFactory connectionFactory;

    public void sendMessage(String message) {
        Connection c = null;
        try {
            c = connectionFactory.createConnection();
            Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(new ActiveMQQueue("inputItemQueue"));
            Message msg = session.createTextMessage(message);
            messageProducer.send(msg);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
