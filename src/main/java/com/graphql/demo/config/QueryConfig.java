package com.graphql.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "query")
public class QueryConfig {

    private String internalQuery;
    private String internalByIdQuery;
    private String salesQuery;
    private String salesByIdQuery;
    private String purchaseQuery;
    private String purchaseByIdQuery;
}
