package com.app.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBusinessProcessor {
    @Autowired
    private String someData;

    @PostConstruct
    public void init() {
        System.out.println("!!!!someData=" + someData);
    }

}
