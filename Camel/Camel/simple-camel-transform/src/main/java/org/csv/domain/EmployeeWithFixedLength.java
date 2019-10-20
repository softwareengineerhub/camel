/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.csv.domain;

import java.util.Date;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

/**
 *
 * @author dprokopiuk
 */
@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {

    @DataField(pos = 1, length = 3, trim = true)
    private int id;
    @DataField(pos = 2, length = 5, trim = true)
    private String name;
    @DataField(pos = 3, length = 8, trim = true)
    private String role;
    @DataField(pos = 4, length = 10, pattern="dd-MM-YYYY")
    private Date joiningDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" + "id=" + id + ", name=" + name + ", role=" + role + ", joiningDate=" + joiningDate + '}';
    }

   
}
