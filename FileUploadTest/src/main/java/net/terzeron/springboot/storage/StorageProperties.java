package net.terzeron.springboot.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by terzeron on 2017. 1. 10..
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "/Users/terzeron/workspace1/SpringBootTest/FileUploadTest/upload";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
