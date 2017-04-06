package net.terzeron.springboot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by terzeron on 2017. 3. 29..
 */
public class Greeting extends ResourceSupport {
    private final int id;
    @Getter private final String content;

    @JsonCreator
    public Greeting(@JsonProperty("id") int id, @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }
}
