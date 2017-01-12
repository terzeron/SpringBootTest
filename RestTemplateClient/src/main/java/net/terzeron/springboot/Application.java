package net.terzeron.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by terzeron on 2017. 1. 9..
 */
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

/*
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        // 위 URL에 접근하면 다음과 같은 결과를 반환함
        // {"type":"success", "value":{"id":7, "quote":"The real benefit of Boot, however, is that it's just Spring. That means any direction the code takes, regardless of complexity, I know it's a safe bet."}}
        // json 구조에 맞춰 Quote와 Value 객체가 동일하게 정의되어 있음

        log.info(quote.toString());
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Bean으로 선언했기 때문에 RestTemplateBuilder가 자동으로 주입되어 사용됨
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    // spring boot가 시작할 때 실행되는 callback인 run()에서 메인 메소드의 로직을 처리
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }

}
