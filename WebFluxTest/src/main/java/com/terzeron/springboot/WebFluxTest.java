package com.terzeron.springboot;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

// https://www.infoq.com/articles/reactor-by-example/
// ./mvnw spring-boot:run

// ExampleController
// curl localhost:8080/hello/mike
// curl localhost:8080/helloDelay/mike/
// curl localhost:8080/hey

// DataExampleController
// http://timurisachenko.com/experiment-3-reactive-spring-webflux-r2dbc-todo-rest-api/
// curl localhost:8080/data
// curl localhost:8080/data/1

@SpringBootApplication
public class WebFluxTest {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxTest.class, args);
    }

    @Bean
    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
        return new R2dbcEntityTemplate(connectionFactory);
    }

    @Bean
    ApplicationRunner init(PersonRepository repo, R2dbcEntityTemplate template) {
        return args -> {
            template.getDatabaseClient().sql("create table IF NOT EXISTS sir" +
                            "(id int auto_increment PRIMARY KEY, first_name varchar (255) not null, last_name varchar (255) " +
                            "not null);")
                    .fetch()
                    .first()
                    .subscribe();
            template.getDatabaseClient().sql("DELETE FROM sir;")
                    .fetch()
                    .first()
                    .subscribe();

            Stream<Sir> stream = Stream.of(
                    new Sir(null, "George", "Michael"),
                    new Sir(null, "Michael", "Jackson"),
                    new Sir(null, "Steve", "Wonder"));

            // initialize the database
            repo.saveAll(Flux.fromStream(stream))
                    .then()
                    .subscribe(); // execute

        };
    }
}
