package com.myretail.rest.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRetailInteraction implements CommandLineRunner {
    

    @Override
    public void run(String...args) throws Exception {
        System.out.println("hi");
    }
    
}
