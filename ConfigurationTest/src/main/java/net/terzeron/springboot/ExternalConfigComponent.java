package net.terzeron.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ExternalConfigComponent {
    private static Logger logger = LoggerFactory.getLogger(ExternalConfigComponent.class);

    @Value("${property.one}")
    public String propertyOne;

    @Value("${property.two}")
    public String propertyTwo;

    @Value("${property.three}")
    private String propertyThree;

    @Value("${property.four}")
    private String propertyFour;

    @Value("${property.five}")
    private String propertyFive;

    @Value("${property.six}")
    private String propertySix;

    @Value("${property.seven}")
    private String propertySeven;

    @PostConstruct
    public void postConstruct() {
        logger.info("Property One: " + propertyOne);     // springApplication.setDefaultProperties()
        logger.info("Property Two: " + propertyTwo);     // from resources/application.properties
        logger.info("Property Three: " + propertyThree); // from /config/application.properties
        logger.info("Property Four: " + propertyFour);   // from resources/application-local.properties by mvn spring-boot:run -Dspring.profiles.active=local
        logger.info("Property Five: " + propertyFive);   // from /config/application-local.properties
        logger.info("Property Six: " + propertySix);     // from command line arguments
        logger.info("Property Seven: " + propertySeven);
    }
}
