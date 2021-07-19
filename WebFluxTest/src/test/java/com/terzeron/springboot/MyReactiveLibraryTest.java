package com.terzeron.springboot;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class MyReactiveLibraryTest {
    @Test
    public void testAlphabet5LimitsToZ() {
        MyReactiveLibrary library = new MyReactiveLibrary();
        StepVerifier.create(library.alphabet5('x'))
            .expectNext("x", "y", "z")
            .expectComplete()
            .verify();
    }
}

