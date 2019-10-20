package com.app;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class MyServiceStepDefinition {

    @Autowired
    private MyService myService;
    private int result;

    @Given("I have a MyService")
    public void Me_have_a_calculator() {
        System.out.println("Calculator: hashCode=" + myService.hashCode());
    }

    @When("Me add {int} and {int}")
    public void Me_add_and(Integer a, Integer b) {
        result = myService.doOperation(true, a, b);
    }

    @When("Me subtract {int} and {int}")
    public void Me_subtract_and(Integer a, Integer b) {
        result = myService.doOperation(false, a, b);
    }

    @Then("Me should get {int}")
    public void Me_should_get(Integer expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }
}
