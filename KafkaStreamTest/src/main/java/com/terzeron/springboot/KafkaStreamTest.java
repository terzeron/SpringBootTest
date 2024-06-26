package com.terzeron.springboot;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@SpringBootApplication
public class KafkaStreamTest {
    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamTest.class, args);
    }

    // single input and output binding
    @Bean
    public Function<KStream<Object, String>, KStream<String, WordCount>> wordcount() {
        // consume KStream<Object, String>
        // produce KStream<String, WordCount>
        return input -> input
                // value: String -> split string as a word array and transform it to a flat map
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                // key: String(word), value: String(word) -> KeyValue class instance
                .map((key, value) -> new KeyValue<>(value, value))
                // group by key
                .groupByKey(Grouped.with(Serdes.String(), Serdes.String()))
                // time window (1min)
                .windowedBy(TimeWindows.of(Duration.ofMillis(60000)))
                // count and store into "wordcount-store"
                .count(Materialized.as("wordcount-store"))
                // convert to result KStream
                .toStream()
                // transform this stream in <String, Long> to map <KeyValue(key, WordCount(key, Date)), Date>
                .map((key, value) -> new KeyValue<>(key.key(),
                        new WordCount(key.key(), value, new Date(key.window().start()),
                                new Date(key.window().end()))));
    }
    // properties 설정
    // spring.cloud.stream.bindings.wordcount-in-0.destination=words
    // spring.cloud.stream.bindings.wordcount-out-0.destination=counts
    // kafka-console-consumer --bootstrap-server localhost:9092 --topic counts
    // 다음 명령을 1분 이내에 여러 차례 실행
    // (echo hello; echo world; echo hello_world; echo java; echo hello; echo coffee) | kafka-console-producer
    // --bootstrap-server localhost:9092 --topic words

    //@Bean
    //public Consumer<KStream<String, String>> process() {
    //    return input -> input.foreach((key, value) -> {
    //        System.out.println("Key: " + key + " Value: " + value);
    //    });
    //}
    // properties 파일 설정
    // spring.cloud.stream.bindings.process-in-0.destination: my-input-topic
    // "process"라는 바인딩 이름이 method 이름과 일치해야 하며 해당 토픽을 kafka에 생성해두어야 함
    // application을 실행해 두고, kafka-console-producer로 데이터를 밀어넣어야 함
    // (date; echo "hello") | kafka-console-producer --bootstrap-server localhost:9092 --topic my-input-topic

}
