package com.terzeron.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfrastructureConfiguration.class)
public class DemoApplicationTests {
    @Autowired
    DatabaseClient database;

    @Autowired
    CoffeeRepository coffeeRepository;

    @Before
    public void setUp() {
        Hooks.onOperatorDebug();
        List<String> statements = Arrays.asList(//
                "DROP TABLE IF EXISTS coffee;",
                "CREATE TABLE coffee (id int, name varchar(255), price int);");
        statements.forEach(it -> database.execute() //
                .sql(it) //
                .fetch() //
                .rowsUpdated() //
                .as(StepVerifier::create) //
                .expectNextCount(1) //
                .verifyComplete());
    }

    @Test
    public void test1() throws IOException {
        Coffee coffee1 = new Coffee(null, "mocha", 1200);
        Coffee coffee2 = new Coffee(null, "java", 1400);
        insertCoffees(coffee1, coffee2);

        coffeeRepository.findByName("java")
                .as(StepVerifier::create)
                .assertNext(coffee2::equals)
                .verifyComplete();

        coffeeRepository.findAll()
                .subscribe(System.out::println);
    }

    private void insertCoffees(Coffee... coffees) {
        coffeeRepository.saveAll(Arrays.asList(coffees))
                .as(StepVerifier::create)
                .expectNextCount(2)
                .verifyComplete();
    }
}
