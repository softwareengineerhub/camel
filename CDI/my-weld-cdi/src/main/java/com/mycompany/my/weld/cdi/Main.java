/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.weld.cdi;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 *
 * @author DProkopiuk
 */
public class Main {
    
    
    public static void main(String[] args) {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        SeContainer container = initializer.initialize();
        Instance<Developer> lazyDeveloper = container.select(Developer.class);
        Developer developer = lazyDeveloper.get();
        String msg = developer.develop();
        System.out.println(msg);
    }
}
