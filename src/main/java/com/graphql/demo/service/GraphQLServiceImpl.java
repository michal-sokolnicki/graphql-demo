package com.graphql.demo.service;

import com.graphql.demo.config.QueryConfig;
import graphql.ExecutionResult;
import graphql.kickstart.execution.GraphQLInvoker;
import graphql.kickstart.execution.GraphQLRequest;
import graphql.kickstart.servlet.input.GraphQLInvocationInputFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GraphQLServiceImpl implements GraphQLService {

    private final QueryConfig queryConfig;
    private final GraphQLInvoker queryInvoker;
    private final GraphQLInvocationInputFactory invocationInputFactory;

    @Override
    public ExecutionResult executeQuery(String queryType, Map<String, Object> variables) {
        if (!queryConfig.getQueries().containsKey(queryType)) {
            throw new IllegalArgumentException("Query " + queryType + " not found in a configuration.");
        }
        String query = queryConfig.getQueries().get(queryType);
        log.info("Running GraphQL query: {}", query);
        return queryInvoker.query(invocationInputFactory.create(
                new GraphQLRequest(
                        query,
                        variables,
                        new HashMap<>(),
                        null
                )
        )).getResult();
    }
}
