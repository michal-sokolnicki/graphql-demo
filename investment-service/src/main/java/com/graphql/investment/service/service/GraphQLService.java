package com.graphql.investment.service.service;

import graphql.ExecutionResult;

import java.util.Map;

public interface GraphQLService {

    ExecutionResult executeQuery(String queryKey, Map<String, Object> variables);
}
