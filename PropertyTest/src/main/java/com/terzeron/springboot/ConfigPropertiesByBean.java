package com.terzeron.springboot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configprops-by-bean.properties")
@Getter
@Setter
@ToString
public class ConfigPropertiesByBean {
    @Bean
    @ConfigurationProperties(prefix = "item")
    public Item newItem() {
        return new Item();
    }
}
