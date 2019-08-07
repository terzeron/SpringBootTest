package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by terzeron on 2017. 1. 9..
 */
@SpringBootApplication
public class RestfulWebService {
    public static void main(String[] args){
        SpringApplication.run(RestfulWebService.class, args);

        // http://localhost:8080/greeting
        // http://localhost:8080/greeting?name=Bob
    }
}
