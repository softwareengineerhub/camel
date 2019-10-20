/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.ch02.csv.link.marshalling;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.csv.domain.Address;
import org.csv.domain.EmployeeWithAddress;
import org.app02.ch02.csv.link.marshalling.route.MyMarshallingRoute;

/**
 *
 * @author dprokopiuk
 */
public class MarshallingMain {

    public static void main(String[] args) throws Exception {
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new MyMarshallingRoute());

        ctx.start();
        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress();
        employeeWithAddress.setId("id1");
        employeeWithAddress.setLastName("LastName1");
        employeeWithAddress.setFirstName("FirstName1");
        Address address = new Address();
        address.setAddressLine("line1");
        address.setCity("City1");
        address.setCountry("Country1");
        address.setState("State1");
        address.setZip("Zip1");
        employeeWithAddress.setAddress(address);

        ProducerTemplate template = ctx.createProducerTemplate();
        template.sendBody("direct:objLinkInput", employeeWithAddress);

        Thread.sleep(5000);
        ctx.stop();
    }
}
