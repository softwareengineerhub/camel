/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.ch04;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 *
 * @author DProkopiuk
 */
public class StepDefinitionsCh04 {
    
    @Given("User is on NetBanking landing page")
    public void user_is_on_NetBanking_landing_page(){
        System.out.println("A) Code is in given test!!!!");
    }    
    
    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
        System.out.println("A) user_login_into_application_with_username_and_password()");
    }
    
    @When("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("A) home_page_is_populated()");
    }
    
    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        System.out.println("A) cards_are_displayed()");
    }
    
}
