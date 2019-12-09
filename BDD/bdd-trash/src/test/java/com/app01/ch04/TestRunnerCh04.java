/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.ch04;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * @author DProkopiuk
 */
@RunWith(Cucumber.class)
@CucumberOptions(        
        features = "classpath:com/app01/ch04",      
        tags={"@my"},
        glue="com.app01.ch04")
public class TestRunnerCh04 {
    
}
