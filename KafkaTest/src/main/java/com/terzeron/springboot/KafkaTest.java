package com.terzeron.springboot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class KafkaTest {
    public static void main(String[] args) {
        SpringApplication.run(KafkaTest.class, args).close();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<Object, Object> template) {
        return args -> {
            template.send(MessageBuilder.withPayload(42).setHeader(KafkaHeaders.TOPIC, "blog").build());
            template.send(MessageBuilder.withPayload("43").setHeader(KafkaHeaders.TOPIC, "blog").build());
            Thread.sleep(5000);
        };
    }
}
