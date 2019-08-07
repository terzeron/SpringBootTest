package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// https://dzone.com/articles/elasticsearch-bulk-indexing-with-spring

@Configuration
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class ESBulkIndex {
    public static void main(String[] args) {
        SpringApplication.run(ESBulkIndex.class, args);
    }
}