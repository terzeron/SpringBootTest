package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.terzeron.springboot") // repo 탐색 범위 (repo 디렉토리)
@EntityScan("com.terzeron.springboot") // entity 탐색 범위 (model 디렉토리)
@SpringBootApplication
public class SimpleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApplication.class, args);
    }
}

