/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.beans;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author DProkopiuk
 */
@Service
public class UserService {
    
    @Inject
    private User user;
    
    
    public void doAction(){
        System.out.println("UserService.user="+user);
    }
}
