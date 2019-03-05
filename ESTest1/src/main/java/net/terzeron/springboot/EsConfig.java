package net.terzeron.springboot;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;


@Configuration
@EnableElasticsearchRepositories(basePackages="net.terzeron.springboot")
public class EsConfig {
    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;

    @Bean
    public Client client() {
        Settings settings = Settings.builder()
                .put("cluster.name", EsClusterName).build();
        try (TransportClient client = new PreBuiltTransportClient(settings)) {
            client.addTransportAddress(new TransportAddress(InetAddress.getByName(EsHost), EsPort));
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}