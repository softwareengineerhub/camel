/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.ch04;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author DProkopiuk
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:com/app02/ch04",
        glue = "com.app02.ch04")
public class TestRunnerApp02Ch04 {

}
