package com.app;


import com.app.beans.MyJmsProducer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jms.*;

import java.io.File;
import java.nio.file.Files;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class MyCamelBddStepDefinition {

    @Autowired
    private MyJmsProducer myJmsProducer;


    @Given("I am going to notify Service")
    public void Me_have_a_calculator() {
        File file = new File("data/output/message.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @When("Me add {int} and {int}")
    public void Me_add_and(Integer a, Integer b) {
        myJmsProducer.sendMessage(String.format("add:[%s;%s]", a, b));
    }

    @When("Me subtract {int} and {int}")
    public void Me_subtract_and(Integer a, Integer b) {
        myJmsProducer.sendMessage(String.format("subtract:[%s;%s]", a, b));
    }

    @Then("Me should get {int}")
    public void Me_should_get(Integer expectedResult) throws Exception {
        Thread.sleep(1000);
        File file = new File("data/output/message.txt");
        assertTrue(file.exists());
        String content = new String(Files.readAllBytes(file.toPath()));
        String[] args=content.split(":");
        assertTrue(args.length==2);
        String[] items = args[1].split(";");
        assertTrue(items.length==2);
        int a = Integer.parseInt(items[0].trim().substring(1));
        int b = Integer.parseInt(items[1].trim().substring(0, items[1].length()-1));
        if ("add".equals(args[0].trim())) {
            assertTrue((a+b)==expectedResult);
        } else if ("subtract".equals(args[0].trim())) {
            assertTrue((a-b)==expectedResult);
        }
        if (file.exists()) {
            file.delete();
        }
        System.out.println(args[0].trim()+ "-----------------Completed-------------------");
    }


}
