/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.ch06;

import cucumber.api.java.Before;

/**
 *
 * @author DProkopiuk
 */
public class Hooks {

    //will be executed only for tagged scenarios
    @Before("@my")
    public void beforeEachScenario(){
        System.out.println("@Before");
    }
    
}
