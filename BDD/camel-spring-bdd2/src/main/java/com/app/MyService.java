package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyService {

    @Autowired
    private Calculator calculator;

    @PostConstruct
    public void init() {
        System.out.println("Calculator= " + calculator);
    }

    public int doOperation(boolean isAdd, int a, int b) {
        return isAdd ? calculator.add(a, b) : calculator.subtract(a, b);
    }

}
