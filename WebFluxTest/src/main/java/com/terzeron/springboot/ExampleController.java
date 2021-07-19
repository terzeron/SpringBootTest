package com.terzeron.springboot;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// https://www.infoq.com/articles/reactor-by-example/
// https://developpaper.com/spring-5-responsive-programming/

@RestController
public class ExampleController {
    private final MyReactiveLibrary reactiveLibrary;

    public ExampleController(MyReactiveLibrary reactiveLibrary) {
        this.reactiveLibrary = reactiveLibrary;
    }

    @GetMapping("hello/{who}")
    public Mono<String> hello(@PathVariable String who) {
        return Mono.just(who)
                .map(w -> "Hello " + w + "!");
    }

    @GetMapping("helloDelay/{who}")
    public Mono<String> helloDelay(@PathVariable String who) {
        return reactiveLibrary.withDelay("Hello " + who + "!!", 2);
    }

    @PostMapping("heyMister")
    public Flux<String> hey(@RequestBody Mono<Sir> body) {
        return Mono.just("Hey mister ")
                .concatWith(body
                        // Flux를 반환해야 하므로 flatMapMany를 사용해야 함
                        .flatMapMany(sir -> Flux.fromArray(sir.getLastName().split("")))
                        .map(String::toUpperCase)
                        .take(1)
                ).concatWith(Mono.just(". how are you?"));
    }
}
