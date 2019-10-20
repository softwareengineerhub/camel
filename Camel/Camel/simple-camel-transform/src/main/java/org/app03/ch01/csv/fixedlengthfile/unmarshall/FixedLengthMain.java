/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app03.ch01.csv.fixedlengthfile.unmarshall;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.app03.ch01.csv.fixedlengthfile.unmarshall.route.FixedLengthRoute;

/**
 *
 * @author dprokopiuk
 */
public class FixedLengthMain {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new FixedLengthRoute());

        context.start();

        Thread.sleep(5000);
        context.stop();
    }
}
