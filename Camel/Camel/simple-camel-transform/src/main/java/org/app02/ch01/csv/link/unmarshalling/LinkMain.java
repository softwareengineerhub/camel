/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch01.csv.link.unmarshalling;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.app02.ch01.csv.link.unmarshalling.route.UnmarshallLinkRoute;

/**
 *
 * @author dprokopiuk
 */
public class LinkMain {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new UnmarshallLinkRoute());

        context.start();

        Thread.sleep(5000);
        context.stop();
    }
}
