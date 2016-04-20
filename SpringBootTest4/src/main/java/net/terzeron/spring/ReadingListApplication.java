package net.terzeron.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootApplication means
//   @Configuration: 설정 클래스임
//   @ComponentScan: 자동으로 application context에 등록됨
//   @EnableAutoConfiguration: 자동 설정
// spring-boot-1.2.0 이후부터는 최상위 annotation를 사용하게 되었음
public class ReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}
}
