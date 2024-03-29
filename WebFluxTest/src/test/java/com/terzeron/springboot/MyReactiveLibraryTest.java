package com.terzeron.springboot;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MyReactiveLibraryTest {
    @Test
    public void testAlphabet5LimitsToZ() {
        MyReactiveLibrary library = new MyReactiveLibrary();
        StepVerifier.create(library.alphabet5('x'))
                .expectNext("x", "y", "z", "{", "|")
                .expectComplete()
                .verify();
    }

    @Test
    public void testAlphabet5LastItemIsAlphabeticalChar() {
        MyReactiveLibrary library = new MyReactiveLibrary();
        StepVerifier.create(library.alphabet5('x'))
                .consumeNextWith(c -> assertThat(c)
                        .as("first is alphabetic").matches("[a-z]"))
                .consumeNextWith(c -> assertThat(c)
                        .as("second is alphabetic").matches("[a-z]"))
                .consumeNextWith(c -> assertThat(c)
                        .as("third is alphabetic").matches("[a-z]"))
                .consumeNextWith(c -> assertThat(c)
                        .as("fourth is alphabetic").matches("[a-z{]"))
                .consumeNextWith(c -> assertThat(c)
                        .as("fourth is alphabetic").matches("[a-z|]"))
                .expectComplete()
                .verify();
    }

    @Test
    public void testWithDelay() {
        MyReactiveLibrary library = new MyReactiveLibrary();
        Duration testDuration = StepVerifier.withVirtualTime(() -> library.withDelay("foo", 30))
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(10))
                .expectNoEvent(Duration.ofSeconds(10))
                .thenAwait(Duration.ofSeconds(10))
                .expectNext("foo")
                .expectComplete()
                .verify();
        System.out.println(testDuration.toMillis() + "ms");
    }
}

