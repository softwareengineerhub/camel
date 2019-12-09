/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.ch03;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DProkopiuk
 */
public class StepDefinitionsApp02Ch03 {
    
    @Given("User is on NetBanking landing page")
    public void user_is_on_NetBanking_landing_page() {
        System.out.println("@Given(");
    }

    @Then("Home page is populated")
    public void home_page_is_populated() {
        System.out.println("@Then: Home page is populated");
    }

    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("@Then: Cards are displayed");
    }

    @When("User sign up with following details")
    public void user_sign_up_with_following_details(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("@When: datatable");
        List<Map<String, String>> list = dataTable.asMaps();
         for(Map<String, String> map: list){
             System.out.println(map);
         }

        
    }
    
}
