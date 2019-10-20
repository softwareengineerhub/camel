package com.app.person;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonStepDefinitions {
    private Person person = new Person();

    @Given("Person with next values")
    public void person_with_next_values(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("--------------@Given------------------------");
        List<List<String>> data = dataTable.asLists();

        List<String> list = data.get(0);
        if(list.get(0).equals("NAME")){
            list = data.get(1);
            String name = list.get(0);
            int age = Integer.parseInt(list.get(1));
            person.setName(name);
            person.setAge(age);
        }else{
            list = data.get(1);
            String lastName = list.get(0);
            int yearOfBirth = Integer.parseInt(list.get(1));
            person.setLastName(lastName);
            person.setYearOfBirth(yearOfBirth);
        }
    }

    @Then("expect the person is updated with below details2")
    public void additional_values(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("--------------@Then------------------------");
        List<List<String>> data = dataTable.asLists(String.class);
        List<String> list = data.get(1);
        List<String> actual = new ArrayList<>();
        actual.add(person.getName());
        actual.add(person.getAge()+"");
        actual.add(person.getLastName());
        actual.add(person.getYearOfBirth()+"");
        assertThat(list).isEqualTo(actual);
    }

    @When("expect the person is updated with below details")
    public void additional_values2(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("--------------@When------------------------");
        List<List<String>> data = dataTable.asLists(String.class);
        List<String> list = data.get(1);
        List<String> actual = new ArrayList<>();
        actual.add(person.getName());
        actual.add(person.getAge()+"");
        actual.add(person.getLastName());
        actual.add(person.getYearOfBirth()+"");
        assertThat(list).isEqualTo(actual);
    }

}
