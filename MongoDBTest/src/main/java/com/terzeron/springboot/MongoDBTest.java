package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * mongodb를 설치하고 시작해야 함 (brew install mongodb; brew services start mongodb)
 * curl -X POST -H "Content-Type: application/json" -d '{"name":"Java Tutorial", "isbn":"978-89-3-0", "author":"Mike Holdman", "pages": 300}' http://localhost:8080/book
 * curl http://localhost:8080/book
 */

@SpringBootApplication
public class MongoDBTest {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MongoDBTest.class, args);
    }
}
