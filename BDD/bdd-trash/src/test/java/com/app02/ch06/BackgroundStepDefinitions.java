/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.ch06;

import com.app02.ch05.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *
 * @author DProkopiuk
 */
public class BackgroundStepDefinitions {  
    
    //ALL 3 methods will be called before each row
    
    @Given("validate the browser")
    public void backgroundStart(){
        System.out.println("backgroundStart()"+hashCode());
        //Is blocking
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }*/
    }    
    
    @When("Browser is triggered")
    public void backgroundService() throws Throwable {
        System.out.println("backgroundService()"+hashCode());
    }
    
    @Then("check if browser is started")
    public void backgroundEnd() throws Throwable {
        System.out.println("backgroundEnd()"+hashCode());
    }
    
}
