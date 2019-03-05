package net.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "terzeron", type = "books")
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;
}
