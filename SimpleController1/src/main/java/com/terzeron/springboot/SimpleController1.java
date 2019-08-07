package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleController1 {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleController1.class, args);

        // You can connect to the localhost:8080
    }
}