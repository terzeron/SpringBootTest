package com.terzeron.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


// https://javabeat.net/spring-boot-external-configurations/

@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ExternalConfigComponent externalConfigComponent;

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(Application.class);

        Map<String, Object> defaultProperties = new HashMap<String, Object>();
        defaultProperties.put("property.one", "Value One");
        defaultProperties.put("property.two", "Value Two");
        application.setDefaultProperties(defaultProperties);

        application.run(args);
    }
}
