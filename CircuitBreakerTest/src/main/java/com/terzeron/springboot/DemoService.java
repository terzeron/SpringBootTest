package com.terzeron.springboot;

import reactor.core.publisher.Mono;

public interface DemoService {
    public Mono<String> slow();
}
