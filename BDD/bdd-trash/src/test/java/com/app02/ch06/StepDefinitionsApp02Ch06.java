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
public class StepDefinitionsApp02Ch06 {
   
    @Given("User is on NetBanking landing page")
    public void user_is_on_NetBanking_landing_page() {
        System.out.println("@Given. hashCode()="+hashCode());
    }

    @When("User login into application with {string} and {string} and {string} and {string} and {string}")
    public void user_login_into_application_with_and_and_and_and(String name, String pass, String mail, String country, String code) {
        String message = String.format("Name=%s; Pass=$s; Mail=%s; Country=%s; Code=%s", name, pass, mail, country, code);
        System.out.println(message);
    }

    @Then("Home page is populated")
    public void home_page_is_populated() {
        System.out.println("@Then: Home page is populated");
    }

    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("@Then: Cards are displayed");
    }

}
