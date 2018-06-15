package net.terzeron.springboot.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModel {
    public static final Logger logger = LoggerFactory.getLogger(TestModel.class);

    public TestModel() {
        logger.debug("log message at DEBUG level from TestModel constructor"); // ignored due to logger level
        logger.info("log message at INFO level from TestModel constructor");
    }
}
