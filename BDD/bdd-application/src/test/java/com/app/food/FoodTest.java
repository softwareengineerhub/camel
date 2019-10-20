package com.app.food;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


//glu - for java classes used in test
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        glue = "com.app.food2",
        features = "classpath:com/app/food")
public class FoodTest {


}
