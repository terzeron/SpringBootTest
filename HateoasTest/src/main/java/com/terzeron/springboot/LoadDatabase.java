package com.terzeron.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
        return args -> {
            log.info("preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("preloading " + repository.save(new Employee("Frodo aggins", "thief")));

            orderRepository.save(new Order("Macbook pro", Status.COMPLETED));
            orderRepository.save(new Order("iphone", Status.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}
