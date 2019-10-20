/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app03.net.transform.bean;

/**
 *
 * @author dprokopiuk
 */
public class CamelBean {

    public String map(String input) {
        String newBody = input.replaceAll(",", "*");
        return newBody;
    }
}
