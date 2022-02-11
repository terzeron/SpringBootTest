package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleFluxTest {
    public static void main(String[] args) {
        //PoliteServer server = new PoliteServer(new KitchenService());
        //server.doingMyJob().subscribe();
        SpringApplication.run(SimpleFluxTest.class, args);
    }
}
