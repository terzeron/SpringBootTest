package com.terzeron.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class MongoDbSliceTest {
    @Autowired
    ItemRepository repository;

    @Test
    void itemRepositorySavesItems() {
        Item sampleItem = new Item("oled lamp", "oled lamp with remote controller", 10.99);

        repository.save(sampleItem)
                .as(StepVerifier::create)
                .expectNextMatches(item -> {
                    assertThat(item.getId()).isNotNull();
                    assertThat(item.getName()).isEqualTo("oled lamp");
                    assertThat(item.getDescription()).isEqualTo("oled lamp with remote controller");
                    assertThat(item.getPrice()).isEqualTo(10.99);

                    return true;
                })
                .verifyComplete();
    }
}
