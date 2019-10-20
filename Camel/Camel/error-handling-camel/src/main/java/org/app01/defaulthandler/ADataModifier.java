/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app01.defaulthandler;

import java.util.logging.Logger;

/**
 *
 * @author dprokopiuk
 */
public class ADataModifier {

    Logger log = Logger.getLogger(ADataModifier.class.getName());

    public String map(String input) throws Exception {
        System.out.println(input);
        input = null;
        String newBody = null;
        try {
            newBody = input.replace(",", "*");
        } catch (RuntimeException e) {
            log.severe("RuntimeException : " + e);
            throw e;
        } catch (Exception e) {
            log.severe("Exception : " + e);
            throw e;
        }
        return newBody;
    }

}
