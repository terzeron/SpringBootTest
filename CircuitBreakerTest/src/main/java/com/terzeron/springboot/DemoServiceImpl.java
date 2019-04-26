package com.terzeron.springboot;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import lombok.AllArgsConstructor;
import org.springframework.cloud.circuitbreaker.commons.Customizer;
import org.springframework.cloud.circuitbreaker.commons.ReactiveCircuitBreaker;
import org.springframework.cloud.circuitbreaker.commons.ReactiveCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {
    private WebClient webClient;
    private ReactiveCircuitBreakerFactory cbFactory;

    public DemoServiceImpl() {
        webClient = WebClient.create("http://naver.com");
    }

    public Mono<String> slow() {
        return webClient.get().uri("/slow").retrieve().bodyToMono(String.class).transform(
                it -> {
                    ReactiveCircuitBreaker cb = cbFactory.create("slow");
                    return cb.run(it, throwable -> Mono.just("fallback"));
                }
        );
    }

    // circuit breaker 기본 설정
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(
                id -> new Resilience4JConfigBuilder(id)
                        .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                        .timeLimiterConfig(
                                TimeLimiterConfig.custom()
                                        .timeoutDuration(Duration.ofSeconds(4))
                                        .build()
                        ).build()
        );
    }

//    // slow를 위한 circuit breaker 커스텀 설정
//    // create할 때 id를 부여했음
//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
//        return factory -> factory.configure(
//                builder -> {
//                    builder
//                            .timeLimiterConfig(
//                                    TimeLimiterConfig.custom()
//                                            .timeoutDuration(Duration.ofSeconds(2))
//                                            .build()
//                            )
//                            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults());
//                }
//                , "slow"
//        );
//    }
}
