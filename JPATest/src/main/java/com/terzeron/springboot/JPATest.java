package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://www.popit.kr/spring-boot%EC%97%90%EC%84%9C-jpa%EC%99%80-spring-data-%ED%99%9C%EC%9A%A9/

@SpringBootApplication
//@EnableAutoConfiguration
public class JPATest {
    public static void main(String[] args) {
        System.setProperty("spring.h2.console.enabled", "true");
        SpringApplication.run(JPATest.class);
    }
}
