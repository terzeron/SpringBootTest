package com.terzeron.springboot;

import com.terzeron.springboot.model.TestModel;
import com.terzeron.springboot.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingTest {
    public static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    public static void main(String[] args) {
        TestModel model = new TestModel();
        TestService service = new TestService();
        service.service();

        SpringApplication.run(LoggingTest.class, args);

        logger.error("message logged at ERROR level");
        logger.warn("message logged at WARN level");
        logger.info("message logged at INFO level");
        logger.debug("message logged at DEBUG level"); // ignored due to root level in logback.xml
    }
}
