/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.v1;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author dprokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        MyProcessor myProcessor = container.select(MyProcessor.class).get();
        myProcessor.process();        
        weld.shutdown();
    }
    
}
