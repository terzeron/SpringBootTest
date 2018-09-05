package net.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by terzeron on 2017. 1. 13..
 */
@SpringBootApplication
public class HelloWorldConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldConfiguration.class, args);
    }

    // http://www.baeldung.com/spring-boot-actuators
    // http://localhost:9001/health
    // http://localhost:9001/metric
    // http://localhost:9001/configprops

}
