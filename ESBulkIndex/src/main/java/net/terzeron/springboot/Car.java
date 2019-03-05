package net.terzeron.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "carIndex", type = "carType", shards = 1, replicas = 0)
class Car implements Serializable {
    @Id
    private Long id;
    private String brand;
    private String model;
    private BigDecimal amount;
}