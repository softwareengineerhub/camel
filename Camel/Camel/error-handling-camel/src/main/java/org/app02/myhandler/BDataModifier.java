/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app02.myhandler;

import java.util.logging.Logger;
import org.app01.defaulthandler.ADataModifier;

/**
 *
 * @author dprokopiuk
 */
public class BDataModifier {

    private Logger log = Logger.getLogger(ADataModifier.class.getName());

    public String mapOnException(String input) throws Exception {
        String newBody = null;
        try {
            newBody = input.replace(",", "*");
        } catch (RuntimeException e) {
            log.severe("RuntimeException : " + e);
            throw e;
            //throw new ApplicationException(e.getMessage());
        } catch (Exception e) {
            log.severe("Exception : " + e);
            throw e;
        }
        return newBody;
    }
}
