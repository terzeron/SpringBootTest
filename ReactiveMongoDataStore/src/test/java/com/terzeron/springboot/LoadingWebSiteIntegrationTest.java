package com.terzeron.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.TEXT_HTML;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class LoadingWebSiteIntegrationTest {
    @Autowired
    WebTestClient client;

    @Test
    void test() {
        client.get().uri("/").exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(TEXT_HTML)
                .expectBody(String.class)
                .consumeWith(exchangeResult -> {
                    assertThat(exchangeResult.getResponseBody()).contains("=\"/add");
                });
    }
}
