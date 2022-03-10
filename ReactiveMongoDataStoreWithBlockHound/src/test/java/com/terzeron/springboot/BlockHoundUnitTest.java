package com.terzeron.springboot;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class BlockHoundUnitTest {
    @Test
    void threadSleepIsABlockingCall() {
        Mono.delay(Duration.ofSeconds(1))
                .flatMap(tick -> {
                    try {
                        Thread.sleep(10);
                        return Mono.just(true);
                    } catch (InterruptedException e) {
                        return Mono.error(e);
                    }
                })
                .as(StepVerifier::create)
                .expectNextMatches(item -> { return item; })
                .verifyComplete();
        // pom.xml에 blockhound-junit-platform 의존성을 추가하고 아래 코드를 활성화시키면 테스트를 통과함
                //.verifyErrorMatches(throwable -> {
                //   assertThat(throwable.getMessage())
                //            .contains("Blocking call! java.lang.Thread.sleep");
                //    return true;
                //});
    }
}
