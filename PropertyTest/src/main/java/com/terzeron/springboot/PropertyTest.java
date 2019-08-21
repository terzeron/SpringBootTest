package com.terzeron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static java.lang.System.exit;

@SpringBootApplication
@EnableConfigurationProperties({ConfigProperties.class, PropertyConversion.class})
public class PropertyTest implements CommandLineRunner {
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private ConfigPropertiesByBean configPropertiesByBean;

    @Autowired
    private PropertyConversion propertyConversion;

    public static void main(String[] args) {
        SpringApplication.run(PropertyTest.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println(configProperties);
        System.out.println(configPropertiesByBean.newItem());
        System.out.println(propertyConversion);

        exit(0);
    }
}
