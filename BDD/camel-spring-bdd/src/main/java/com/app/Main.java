package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Main.class, args);
        //Thread.sleep(Integer.MAX_VALUE);
    //    System.out.println();
    }

}
