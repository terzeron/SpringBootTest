package com.terzeron.springboot;

import com.terzeron.springboot.storage.StorageProperties;
import com.terzeron.springboot.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileUploadTest {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadTest.class, args);
    }

    //@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}