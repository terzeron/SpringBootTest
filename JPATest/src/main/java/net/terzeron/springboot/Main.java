package net.terzeron.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;

// https://www.popit.kr/spring-boot%EC%97%90%EC%84%9C-jpa%EC%99%80-spring-data-%ED%99%9C%EC%9A%A9/

@SpringBootApplication
@EnableAutoConfiguration
public class Main implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        System.setProperty("spring.h2.console.enabled", "true");
        SpringApplication.run(Main.class);
    }

    // 에러 처리
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    }
}
