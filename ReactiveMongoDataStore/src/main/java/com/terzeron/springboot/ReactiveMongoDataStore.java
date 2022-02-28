package com.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class ReactiveMongoDataStore {
    public static void main(String[] args) {
        //Hooks.onOperatorDebug();
        BlockHound.builder()
                .allowBlockingCallsInside(TemplateEngine.class.getCanonicalName(),"process")
                .install();
        SpringApplication.run(ReactiveMongoDataStore.class, args);
    }
}
