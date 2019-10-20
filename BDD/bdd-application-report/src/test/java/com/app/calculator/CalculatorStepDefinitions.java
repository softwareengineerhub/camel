package com.app.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions {

    private Calculator calculator;
    private int result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
        System.out.println("Calculator: hashCode="+calculator.hashCode());
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b) {
        result = calculator.add(a, b);
    }

    @When("I subtract {int} and {int}")
    public void i_subtract_and(Integer a, Integer b) {
        result = calculator.subtract(a, b);
    }

    @Then("I should get {int}")
    public void i_should_get(Integer expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }

}
