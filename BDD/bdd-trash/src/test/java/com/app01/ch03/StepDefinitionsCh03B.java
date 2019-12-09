/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.ch03;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 *
 * @author DProkopiuk
 */
public class StepDefinitionsCh03B {
    
    @Given("User2 is on NetBanking landing page2")
    public void init(){
        System.out.println("init()!!!!!!!!!!!!StepDefinitionsCh02B!!!!!!!!!!!!!!!");
    }    
    
    @When("User login into application with username and password2")
    public void password2() throws Throwable {
        System.out.println("#######PASSWORD2########################");
    }
    
    @When("Home2 page is populated2")
    public void home_page_is_populated() throws Throwable {
        System.out.println("$$$$$$$$$$$$populated2$$$$$$$$$$$$");
    }
    
    @And("^Cards are displayed2")
    public void cards_are_displayed() throws Throwable {
        System.out.println("cards_are_displayed()");
    }
    
}
