package com.terzeron.springboot;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaStreamTest {
    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamTest.class, args);
    }

    @Bean
    public java.util.function.Consumer<KStream<String, String>> process() {
        return input -> input.foreach((key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });
    }

    // properties 파일 설정
    // spring.cloud.stream.bindings.process-in-0.destination: my-input-topic
    // "process"라는 바인딩 이름이 method 이름과 일치해야 하며 해당 토픽을 kafka에 생성해두어야 함
    // application을 실행해 두고, kafka-console-producer로 데이터를 밀어넣어야 함
    // (date; echo "hello") | kafka-console-producer --bootstrap-server localhost:9092 --topic my-input-topic
}
