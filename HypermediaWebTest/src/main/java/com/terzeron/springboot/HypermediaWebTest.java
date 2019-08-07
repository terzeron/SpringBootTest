package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by terzeron on 2017. 3. 29..
 */
@SpringBootApplication
public class HypermediaWebTest {
    public static void main(String[] args) {
        SpringApplication.run(HypermediaWebTest.class, args);
    }

    // http://localhost:8080/greeting
    // http://localhost:8080/greeting?name=
    // http://localhost:8080/greeting?name=James
}
