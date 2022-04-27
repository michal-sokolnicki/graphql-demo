package com.graphql.investment.service.service.impl;

import com.graphql.investment.service.config.QueryConfig;
import graphql.ExecutionResult;
import graphql.ExecutionResultImpl;
import graphql.kickstart.execution.GraphQLInvoker;
import graphql.kickstart.execution.GraphQLQueryResult;
import graphql.kickstart.execution.GraphQLRequest;
import graphql.kickstart.execution.input.GraphQLSingleInvocationInput;
import graphql.kickstart.servlet.input.GraphQLInvocationInputFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GraphQLServiceImplTest {

    @Mock
    private QueryConfig queryConfig;

    @Mock
    private GraphQLInvoker queryInvoker;

    @Mock
    private GraphQLInvocationInputFactory invocationInputFactory;

    @InjectMocks
    private GraphQLServiceImpl graphQLService;

    @Test
    void executeQuery() {
        // given
        when(queryConfig.getQueries()).thenReturn(Map.of("key", "query test"));
        when(invocationInputFactory.create(any(GraphQLRequest.class)))
                .thenReturn(mock(GraphQLSingleInvocationInput.class));
        when(queryInvoker.query(any(GraphQLSingleInvocationInput.class)))
                .thenReturn(GraphQLQueryResult.create(
                        new ExecutionResultImpl("response", Collections.emptyList())));

        // when
        ExecutionResult result = graphQLService.executeQuery("key", Collections.emptyMap());

        // then
        assertThat(result.getData().toString()).hasToString("response");
    }

}