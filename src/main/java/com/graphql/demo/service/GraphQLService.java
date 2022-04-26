package com.graphql.demo.service;

import graphql.ExecutionResult;

import java.util.Map;

public interface GraphQLService {
    ExecutionResult executeQuery(String queryKey, Map<String, Object> variables);
}
