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
public class BulkMarshallingMain {

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
        
        EmployeeWithAddress employeeWithAddress2 = new EmployeeWithAddress();
        employeeWithAddress2.setId("id2");
        employeeWithAddress2.setLastName("LastName2");
        employeeWithAddress2.setFirstName("FirstName2");
        Address address2 = new Address();
        address2.setAddressLine("line2");
        address2.setCity("City2");
        address2.setCountry("Country2");
        address2.setState("State2");
        address2.setZip("Zip2");
        employeeWithAddress2.setAddress(address2);

        EmployeeWithAddress[] array = {employeeWithAddress, employeeWithAddress2};

        ProducerTemplate template = ctx.createProducerTemplate();
        template.sendBody("direct:objLinkInput", array);

        Thread.sleep(5000);
        ctx.stop();
    }

}
