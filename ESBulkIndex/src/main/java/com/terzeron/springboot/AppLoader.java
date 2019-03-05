package com.terzeron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppLoader implements CommandLineRunner {
    @Autowired
    IndexerService indexerService;
    @Override
    public void run(String... strings) throws Exception {
        indexerService.bulkIndex();
    }
}