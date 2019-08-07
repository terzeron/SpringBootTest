package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://javabeat.net/spring-data-jpa/
// https://javabeat.net/spring-data-jpa-query/

/*
 * mysql이 설치되고 실행되어야 함(brew install mysql; brew services start mysql)
 * schema 생성하고 데이터 insert해야 함
 * curl http://localhost/books/
 */

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
