/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.cdi.denis;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

/**
 *
 * @author DProkopiuk
 */
public class DenisRouteB extends RouteBuilder {
    
    @Inject
    //@ContextName("custom")    
    //@Named("myCamelName")
    private CamelContext context;

    @Override
    public void configure() throws Exception {
        System.out.println("--------------DenisRouteB---------------");
        //name is custom
        System.out.println(context);
        System.out.println("---------------DenisRouteB--------------");
    }
    
}
