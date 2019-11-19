package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 원본: https://spring.io/guides/tutorials/bookmarks/

@SpringBootApplication
public class HateoasTest {
    public static void main(String[] args) {
        SpringApplication.run(HateoasTest.class, args);

        // curl -v localhost:8080/employees
        // curl -v localhost:8080/employees/99
        // curl -X POST -H 'Content-type: application/json' -d '{ "name": "Samwise Gamgee", "role": "gardener"}' localhost:8080/employees
        // curl -X PUT -H 'Content-type: application/json' -d '{ "name": "Samwise Gamgee", "role": "ring bearer"}' localhost:8080/employees/3
        // curl -X DELETE localhost:8080/employees/3
        // curl localhost:8080/employees/3

        // curl -v -X POST localhost:8080/employees -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'
        // curl -v -X PUT localhost:8080/employees/3 -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'

        // curl -v localhost:8080/orders
    }
}
