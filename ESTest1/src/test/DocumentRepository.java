package net.terzeron.springboot;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DocumentRepository extends ElasticsearchRepository<Document, String> {
    List<Document> findByDocTitleEndsWith(String name);
    List<Document> findByDocTitleStartsWith(String name);
    List<Document> findByDocTypeEndsWith(String name);
    List<Document> findByDocTypeStartsWith(String name);
}