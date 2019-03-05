package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // with admin/admin
    // http://localhost:8081/details/actuator
    // http://localhost:8081/details/autoconfig    *
    // http://localhost:8081/details/beans         *
    // http://localhost:8081/details/configprops   *
    // http://localhost:8081/details/dump          *
    // http://localhost:8081/details/env           *
    // http://localhost:8081/details/health        *
    // http://localhost:8081/details/info          *
    // http://localhost:8081/details/metrics       *
    // http://localhost:8081/details/mappings      *
    // http://localhost:8081/details/shutdown
    // http://localhost:8081/details/trace         *
    // http://localhost:8081/details/logfile
    // http://localhost:8081/details/flyway
    // http://localhost:8081/details/liquibase

    // application.properties에 설정이 켜진 endpoint 위주로 접근이 가능함
}
