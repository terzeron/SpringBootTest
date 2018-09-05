package net.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by terzeron on 2017. 1. 13..
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // http://www.baeldung.com/spring-boot-actuators
    // http://localhost:9000/hello-world
    // http://localhost:9000/actuator/
    // http://localhost:9000/actuator/health
    // http://localhost:9000/actuator/info
}
