package com.terzeron.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestService {
    private Logger logger = LoggerFactory.getLogger(TestService.class);

    public void service() {
        logger.info("message at INFO level from TestService.service()"); // ignored due to logger level
        logger.warn("message at WARN level from TestService.service()");
    }
}
