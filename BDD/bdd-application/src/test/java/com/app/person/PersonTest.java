package com.app.person;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        glue = "com.app.person",
        features = "classpath:com/app/person")
public class PersonTest {
}
