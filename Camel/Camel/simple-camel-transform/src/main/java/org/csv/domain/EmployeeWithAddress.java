/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.csv.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.Link;

/**
 *
 * @author dprokopiuk
 */
@CsvRecord(separator = ",", skipFirstLine = true, generateHeaderColumns = true)
public class EmployeeWithAddress {

    @DataField(pos = 1)
    private String id;
    @DataField(pos = 2)
    private String firstName;
    @DataField(pos = 3)
    private String lastName;

    @Link
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    

    @Override
    public String toString() {
        return "EmployeeWithAddress{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + '}';
    }
    

    

}
