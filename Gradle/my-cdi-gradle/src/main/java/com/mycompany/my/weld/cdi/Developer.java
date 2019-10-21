/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.weld.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author DProkopiuk
 */
@ApplicationScoped
public class Developer {
    
    @Inject
    Coffee coffee;
    
    public String develop(){
        return this.coffee.drink()+" develop";
    }
    
}
