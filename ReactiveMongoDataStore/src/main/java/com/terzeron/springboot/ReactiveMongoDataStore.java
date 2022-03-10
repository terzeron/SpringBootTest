package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ReactiveMongoDataStore {
    public static void main(String[] args) {
        //Hooks.onOperatorDebug();
        //BlockHound.builder()
                //.allowBlockingCallsInside(TemplateEngine.class.getCanonicalName(),"process")
                //.install();

        SpringApplication.run(ReactiveMongoDataStore.class, args);
    }
}
